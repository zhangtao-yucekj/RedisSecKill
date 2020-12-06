package com.tao.demo.controller;

import com.tao.demo.common.Constants;
import com.tao.demo.common.ReturnMessage;
import com.tao.demo.entity.Product;
import com.tao.demo.service.ProductService;
import com.tao.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Controller
@RequestMapping("/seckill")
public class SecKillController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final ConcurrentHashMap<Integer, Boolean> productSoldOutMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, Boolean> getProductSoldOutMap() {
        return productSoldOutMap;
    }

    @PostConstruct
    public void init() {
        List<Product> products = productService.listProducts();
        for (Product p : products) {
            //相当于Jedis.set(key, value);
            stringRedisTemplate.opsForValue().set(Constants.REDIS_PRODUCT_STOCK_PREFIX + p.getId(), p.getStock() + "");
        }
    }

    @PostMapping("/{productId}")
    public ReturnMessage secKill(@PathVariable("productId") Integer productId) {
        if (productSoldOutMap.get(productId) != null) {
            return ReturnMessage.error("商品已售完");
        }
        Long stock = stringRedisTemplate.opsForValue().decrement(Constants.REDIS_PRODUCT_STOCK_PREFIX + productId);
        if (stock < 0) {
            log.info("商品已售完");
            productSoldOutMap.put(productId, true);
            stringRedisTemplate.opsForValue().increment(Constants.REDIS_PRODUCT_STOCK_PREFIX + productId);
            return ReturnMessage.error("商品已售完");
        }
        try {
            orderService.secKill(productId);
        } catch (Exception e) {
            stringRedisTemplate.opsForValue().increment(Constants.REDIS_PRODUCT_STOCK_PREFIX + productId);
            if (productSoldOutMap.get(productId) != null) {
                productSoldOutMap.remove(productId);
            }
            log.info("创建订单失败");
            return ReturnMessage.error("创建订单失败：" + e.getMessage());
        }
        return ReturnMessage.success();
    }
}

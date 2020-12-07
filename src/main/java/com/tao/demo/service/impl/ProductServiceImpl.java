package com.tao.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tao.demo.dao.ProductDAO;
import com.tao.demo.entity.Product;
import com.tao.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Override
    public List<Product> listProducts() {
        return Collections.emptyList();
    }

    @Override
    public void addProduct(Product product) {
        productDAO.insert(product);
        log.info("productId: {}", product.getId());
    }

    @Override
    public void deleteProduct(Integer id) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        productDAO.delete(queryWrapper);
    }
}

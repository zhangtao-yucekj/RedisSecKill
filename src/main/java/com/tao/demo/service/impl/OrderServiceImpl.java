package com.tao.demo.service.impl;

import com.tao.demo.dao.ProductDAO;
import com.tao.demo.dao.SecKillDAO;
import com.tao.demo.entity.Product;
import com.tao.demo.entity.SecKillOrder;
import com.tao.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    SecKillDAO secKillDAO;
    @Autowired
    ProductDAO productDAO;

    @Override
    @Transactional
    public void secKill(Integer id) {
        productDAO.updateProductById(id);
        Product product = productDAO.selectById(id);
        SecKillOrder secKillOrder = new SecKillOrder();
        secKillOrder.setProductId(id);
        secKillOrder.setAmount(product.getPrice());
        secKillDAO.insert(secKillOrder);
    }
}

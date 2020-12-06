package com.tao.demo.service.impl;

import com.tao.demo.entity.Product;
import com.tao.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> listProducts() {
        return Collections.emptyList();
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void deleteProduct(Integer id) {

    }
}

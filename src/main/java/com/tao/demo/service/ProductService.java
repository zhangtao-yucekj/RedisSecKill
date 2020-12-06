package com.tao.demo.service;

import com.tao.demo.entity.Product;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有商品
     */
    List<Product> listProducts();
    /**
     * 添加商品
     */
    void addProduct(Product product);
    /**
     * 删除商品
     */
    void deleteProduct(Integer id);
}

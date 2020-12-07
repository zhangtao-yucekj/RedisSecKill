package com.tao.demo.controller;

import com.tao.demo.common.ReturnMessage;
import com.tao.demo.entity.Product;
import com.tao.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public ReturnMessage addProduct(Product product) {
        productService.addProduct(product);
        return ReturnMessage.success();
    }

    @PostMapping("/delProductById")
    public void delProductById(Integer id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/findAllProduct")
    public void findAllProduct() {
        productService.listProducts();
    }

}

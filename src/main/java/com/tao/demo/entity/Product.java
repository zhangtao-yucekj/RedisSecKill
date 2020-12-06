package com.tao.demo.entity;

import lombok.Data;

@Data
public class Product {
    /**
     * 商品id
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品库存
     */
    private Integer stock;
    /**
     * 商品图片
     */
    private String pic;
}

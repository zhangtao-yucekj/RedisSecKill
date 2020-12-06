package com.tao.demo.entity;

import lombok.Data;

@Data
public class SecKillOrder {
    /**
     * 订单id
     */
    private Integer id;
    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 商品总金额
     */
    private Double amount;
}

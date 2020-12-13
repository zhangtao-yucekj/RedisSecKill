package com.tao.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("seckillorder")
public class SecKillOrder {
    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
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

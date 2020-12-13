package com.tao.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tao.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductDAO extends BaseMapper<Product> {

    @Select("update product set stock = stock-1 where id = #{id}")
    void updateProductById(@Param("id") Integer id);
}

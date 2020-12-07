package com.tao.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tao.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO extends BaseMapper<Product> {
}

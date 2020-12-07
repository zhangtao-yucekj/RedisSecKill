package com.tao.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tao.demo.entity.SecKillOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecKillDAO extends BaseMapper<SecKillOrder> {
}

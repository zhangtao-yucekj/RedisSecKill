package com.tao.demo.service.impl;

import com.tao.demo.dao.SecKillDAO;
import com.tao.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    SecKillDAO secKillDAO;

    @Override
    public void secKill(Integer id) {

    }
}

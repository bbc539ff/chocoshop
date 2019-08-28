package com.chocoshop.service;

import com.chocoshop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    @Autowired
    OrderMapper orderMapper;

}

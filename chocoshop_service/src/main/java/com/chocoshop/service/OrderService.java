package com.chocoshop.service;

import com.chocoshop.mapper.OrderMapper;
import com.chocoshop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public List<Order> showAllOrders(){
        return orderMapper.selectAll();
    }

    public int addOrder(Order order){
        return orderMapper.insert(order);
    }

    public int deleteOrder(Order order){
        return orderMapper.delete(order);
    }

    public int updateOrder(Order order){
        return orderMapper.updateByPrimaryKeySelective(order);
    }
}

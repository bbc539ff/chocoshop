package com.chocoshop.mapper;

import com.chocoshop.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends tk.mybatis.mapper.common.Mapper<Order> {
}

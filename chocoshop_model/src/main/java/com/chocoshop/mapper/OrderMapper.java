package com.chocoshop.mapper;

import com.chocoshop.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends tk.mybatis.mapper.common.Mapper<Order> {

    @Select("<script>" +
            "SELECT * FROM cc_order " +
            "<where>" +
            "<if test=\"orderUuid != null\">" +
            "order_uuid = #{orderUuid}" +
            "</if>" +
            "<if test=\"orderPayment != null\">" +
            "AND order_payment = #{orderPayment}" +
            "</if>" +
            "<if test=\"orderPaymentType != null\">" +
            "AND order_payment_type = #{orderPaymentType}" +
            "</if>" +
            "<if test=\"orderStatus != null\">" +
            "order_status = #{orderStatus}" +
            "</if>" +
            "<if test=\"orderCreateTime != null\">" +
            "AND order_create_time = #{orderCreateTime}" +
            "</if>" +
            "<if test=\"orderUpdateTime != null\">" +
            "AND order_update_time = #{orderUpdateTime}" +
            "</if>" +
            "<if test=\"orderPaymentTime != null\">" +
            "order_payment_time = #{orderPaymentTime}" +
            "</if>" +
            "<if test=\"orderConsignTime != null\">" +
            "AND order_consign_time = #{orderConsignTime}" +
            "</if>" +
            "<if test=\"orderEndTime != null\">" +
            "AND order_end_time = #{orderEndTime}" +
            "</if>" +
            "<if test=\"orderCloseTime != null\">" +
            "order_close_time = #{orderCloseTime}" +
            "</if>" +
            "<if test=\"orderShippingCode != null\">" +
            "AND order_shipping_code = #{orderShippingCode}" +
            "</if>" +
            "<if test=\"memberUuid != null\">" +
            "AND member_uuid = #{memberUuid}" +
            "</if>" +
            "</where>" +
            "</script>")
    @Results({
            @Result(property = "orderUuid", column = "order_uuid"),
            @Result(property = "orderPayment", column = "order_payment"),
            @Result(property = "orderPaymentType", column = "order_payment_type"),
            @Result(property = "orderStatus", column = "order_status"),
            @Result(property = "orderCreateTime", column = "order_create_time"),
            @Result(property = "orderUpdateTime", column = "order_update_time"),
            @Result(property = "orderPaymentTime", column = "order_payment_time"),
            @Result(property = "orderConsignTime", column = "order_consign_time"),
            @Result(property = "orderEndTime", column = "order_end_time"),
            @Result(property = "orderCloseTime", column = "order_close_time"),
            @Result(property = "orderShippingCode", column = "order_shipping_code"),
            @Result(property = "memberUuid", column = "member_uuid"),
    })
    List<Order> search(Order order);
}

package com.chocoshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="cc_order")
public class Order implements Serializable {

    @Id
    private String orderUuid;
    private Double orderPayment;
    private Integer orderPaymentType;
    private Integer orderStatus;
    private Date orderCreateTime;
    private Date orderUpdateTime;
    private Date orderPaymentTime;
    private Date orderConsignTime;
    private Date orderEndTime;
    private Date orderCloseTime;
    private String orderShippingCode;
    private String memberUuid;
    private String orderGoodsList;

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public Double getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(Double orderPayment) {
        this.orderPayment = orderPayment;
    }

    public Integer getOrderPaymentType() {
        return orderPaymentType;
    }

    public void setOrderPaymentType(Integer orderPaymentType) {
        this.orderPaymentType = orderPaymentType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderUpdateTime() {
        return orderUpdateTime;
    }

    public void setOrderUpdateTime(Date orderUpdateTime) {
        this.orderUpdateTime = orderUpdateTime;
    }

    public Date getOrderPaymentTime() {
        return orderPaymentTime;
    }

    public void setOrderPaymentTime(Date orderPaymentTime) {
        this.orderPaymentTime = orderPaymentTime;
    }

    public Date getOrderConsignTime() {
        return orderConsignTime;
    }

    public void setOrderConsignTime(Date orderConsignTime) {
        this.orderConsignTime = orderConsignTime;
    }

    public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public Date getOrderCloseTime() {
        return orderCloseTime;
    }

    public void setOrderCloseTime(Date orderCloseTime) {
        this.orderCloseTime = orderCloseTime;
    }

    public String getOrderShippingCode() {
        return orderShippingCode;
    }

    public void setOrderShippingCode(String orderShippingCode) {
        this.orderShippingCode = orderShippingCode;
    }

    public String getMemberUuid() {
        return memberUuid;
    }

    public void setMemberUuid(String memberUuid) {
        this.memberUuid = memberUuid;
    }

    public String getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(String orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderUuid='" + orderUuid + '\'' +
                ", orderPayment=" + orderPayment +
                ", orderPaymentType=" + orderPaymentType +
                ", orderStatus=" + orderStatus +
                ", orderCreateTime=" + orderCreateTime +
                ", orderUpdateTime=" + orderUpdateTime +
                ", orderPaymentTime=" + orderPaymentTime +
                ", orderConsignTime=" + orderConsignTime +
                ", orderEndTime=" + orderEndTime +
                ", orderCloseTime=" + orderCloseTime +
                ", orderShippingCode='" + orderShippingCode + '\'' +
                ", memberUuid='" + memberUuid + '\'' +
                ", orderGoodsList='" + orderGoodsList + '\'' +
                '}';
    }
}

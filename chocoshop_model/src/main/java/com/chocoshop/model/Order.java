package com.chocoshop.model;

import java.util.Date;

public class Order {
    private String order_uuid;
    private Double payment;
    private Integer payment_type;
    private Integer status;
    private Date create_time;
    private Date update_time;
    private Date payment_time;
    private Date consign_time;
    private Date end_time;
    private Date close_time;
    private String shipping_code;
    private String muuid;

    public String getOrder_uuid() {
        return order_uuid;
    }

    public void setOrder_uuid(String order_uuid) {
        this.order_uuid = order_uuid;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Integer getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(Integer payment_type) {
        this.payment_type = payment_type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(Date payment_time) {
        this.payment_time = payment_time;
    }

    public Date getConsign_time() {
        return consign_time;
    }

    public void setConsign_time(Date consign_time) {
        this.consign_time = consign_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getClose_time() {
        return close_time;
    }

    public void setClose_time(Date close_time) {
        this.close_time = close_time;
    }

    public String getShipping_code() {
        return shipping_code;
    }

    public void setShipping_code(String shipping_code) {
        this.shipping_code = shipping_code;
    }

    public String getMuuid() {
        return muuid;
    }

    public void setMuuid(String muuid) {
        this.muuid = muuid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_uuid='" + order_uuid + '\'' +
                ", payment=" + payment +
                ", payment_type=" + payment_type +
                ", status=" + status +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", payment_time=" + payment_time +
                ", consign_time=" + consign_time +
                ", end_time=" + end_time +
                ", close_time=" + close_time +
                ", shipping_code='" + shipping_code + '\'' +
                ", muuid='" + muuid + '\'' +
                '}';
    }
}

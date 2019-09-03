package com.chocoshop.controller;

import com.chocoshop.model.Order;
import com.chocoshop.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/admin/order-info/index")
    public String index(){
        return "order_info";
    }

    @RequestMapping("/admin/order-info/list")
    @ResponseBody
    public Map<String, Object> adminList(int page, int rows){
        PageHelper.startPage(page, rows);
        List<Order> categoryList = orderService.showAllOrders();
        Map<String, Object> map = new HashMap<>();
        map.put("total", orderService.countOrder());
        map.put("rows", categoryList);
        return map;
    }

    @RequestMapping("/admin/order-info/add")
    @ResponseBody
    public String add(Order order){
        if(orderService.addOrder(order) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/order-info/update")
    @ResponseBody
    public String update(Order order){
        if(orderService.updateOrder(order) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/order-info/delete")
    @ResponseBody
    public String delete(String orderUuid){
        Order order = new Order();
        order.setOrderUuid(orderUuid);
        if(orderService.deleteOrder(order) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/order-info/search")
    @ResponseBody
    public List<Order> searchCategory(Order order){
        System.out.println(order);
        List<Order> categoryList = orderService.search(order);
        System.out.println(categoryList);
        return categoryList;
    }
}

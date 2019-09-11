package com.chocoshop.controller.user;

import com.chocoshop.model.Goods;
import com.chocoshop.model.Order;
import com.chocoshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserOrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(path = "/user/order/submit", method = RequestMethod.POST)
    public String generateOrder(@CookieValue String shoppingCart, Order order){
        // TODO !!!
        orderService.addOrder(order);
        return "";
    }

    @RequestMapping(path = "/user/order/show-order")
    public String userOrder(Model model){
        return "show_order";
    }
}

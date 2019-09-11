package com.chocoshop.controller.user;

import com.chocoshop.model.Category;
import com.chocoshop.model.Goods;
import com.chocoshop.service.CategoryService;
import com.chocoshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class UserGoodsController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/user/goods/shopping-cart")
    public String shoppingCart(@CookieValue("shoppingCart") String shoppingCart, Model model) {
        try {
            String[] str = shoppingCart.split(",");
            LinkedHashMap<Goods, Integer> goodsMap = new LinkedHashMap<>();
            for (String goodsMsg : str) {
                if ("".equals(goodsMsg.trim())) continue;

                Long goodsId = Long.parseLong(goodsMsg.trim().split("/")[0]);
                Integer num = Integer.parseInt(goodsMsg.trim().split("/")[1]);
                Goods goods = goodsService.getGoodsById(goodsId);
                goodsMap.put(goods, num);

            }
            model.addAttribute("goodsMap", goodsMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/user/shopping_cart";
    }

    @RequestMapping(path = "/user/goods/search")
    @ResponseBody
    public List<Goods> search(Goods goods) {
        System.out.println(goods);
        List<Goods> goodsList = goodsService.search(goods);
        System.out.println(goodsList);
        return goodsList;
    }

    @RequestMapping(path = "/user/goods/show-goods")
    public String showGoods(Goods goods, Model model) {
        List<Goods> goodsList = goodsService.search(goods);
        for (Goods goods1 : goodsList) {
            goods1.setGoodsImageurl(goods1.getGoodsImageurl().split(",")[0]);
        }
        model.addAttribute("goodsList", goodsList);
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "/user/show_goods";
    }

}

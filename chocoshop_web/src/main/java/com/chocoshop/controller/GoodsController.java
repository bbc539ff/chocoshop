package com.chocoshop.controller;

import com.chocoshop.model.Goods;
import com.chocoshop.service.GoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    public GoodsService goodsService;

    @GetMapping("/admin/goods-info/list")
    @ResponseBody
    public List<Goods> showAllGoods(Model model){
        return goodsService.showAllGoods();
    }

    @RequestMapping("/admin/goods-info/index")
    public String showGoodsPage() throws IOException {
        return "goods_info";
    }

    @RequestMapping("/admin/goods-info/add")
    @ResponseBody
    public String add(Goods goods){
        System.out.println(goods);
        if(goodsService.addGoods(goods) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/goods-info/update")
    @ResponseBody
    public String update(Goods goods, Model model){
        if(goodsService.updateGoods(goods) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/goods-info/delete")
    @ResponseBody
    public String delete(Long goodsId){
        Goods goods = new Goods();
        goods.setGoodsId(goodsId);
        if(goodsService.deleteGoods(goods) == 1){
            return "success";
        } else{
            return "error";
        }
    }
}

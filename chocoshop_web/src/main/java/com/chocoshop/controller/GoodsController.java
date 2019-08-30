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
@RequestMapping("/admin/goods")
public class GoodsController {
    @Autowired
    public GoodsService goodsService;

    @GetMapping("/show-list")
    @ResponseBody
    public List<Goods> showAllGoods(Model model){
        return goodsService.showAllGoods();
    }

    @RequestMapping("/admin/goods")
    public String showGoodsPage(Model model) throws IOException {
        model.addAttribute("goodsList", goodsService.showAllGoods());
        return "goods";
    }
}

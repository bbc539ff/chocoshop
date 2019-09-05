package com.chocoshop.controller;

import com.chocoshop.model.Goods;
import com.chocoshop.service.GoodsService;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {
    @Autowired
    public GoodsService goodsService;

    @RequiresPermissions({"goods:view"})
    @GetMapping("/admin/goods-info/list")
    @ResponseBody
    public Map<String, Object> showAllGoods(int page, int rows){
        PageHelper.startPage(page, rows);
        List<Goods> goodsList = goodsService.showAllGoods();
        Map<String, Object> map = new HashMap<>();
        map.put("total", goodsService.countGoods());
        map.put("rows", goodsList);
        return map;
    }

    @RequiresPermissions({"goods:view"})
    @RequestMapping("/admin/goods-info/index")
    public String showGoodsPage() throws IOException {
        return "goods_info";
    }

    @RequiresPermissions({"goods:view", "goods:add"})
    @RequestMapping("/admin/goods-info/add")
    @ResponseBody
    public String add(Goods goods, MultipartFile[] files){
        System.out.println(goods);
        if(goodsService.addGoods(goods, files) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"goods:view", "goods:update"})
    @RequestMapping("/admin/goods-info/update")
    @ResponseBody
    public String update(Goods goods, MultipartFile[] files){
        if(goodsService.updateGoods(goods, files) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"goods:view", "goods:delete"})
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

    @RequiresPermissions({"goods:view"})
    @RequestMapping("/admin/goods-info/search")
    @ResponseBody
    public List<Goods> search(Goods goods){
        System.out.println(goods);
        List<Goods> goodsList = goodsService.search(goods);
        System.out.println(goodsList);
        return goodsList;
    }
}

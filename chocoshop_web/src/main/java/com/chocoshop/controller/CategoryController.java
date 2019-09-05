package com.chocoshop.controller;

import com.chocoshop.model.Category;
import com.chocoshop.service.CategoryService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequiresPermissions({"category:view"})
    @RequestMapping("/admin/category-info/index")
    public String categoryIndex(){
        return "category_info";
    }

    @RequiresPermissions({"category:view"})
    @RequestMapping("/admin/category-info/list")
    @ResponseBody
    public Map<String, Object> categoryList(int page, int rows){
        PageHelper.startPage(page, rows);
        List<Category> categoryList = categoryService.getAllCategory();
        Map<String, Object> map = new HashMap<>();
        map.put("total", categoryService.countCategory());
        map.put("rows", categoryList);
        return map;
    }

    @RequiresPermissions({"category:view", "category:update"})
    @RequestMapping("/admin/category-info/update")
    @ResponseBody
    public String updateCategory(Category category, Model model){
        if(categoryService.updateCategory(category) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"category:view", "category:add"})
    @RequestMapping("/admin/category-info/add")
    @ResponseBody
    public String addCategory(Category category, Model model){
        if(categoryService.addCategory(category) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"category:view", "category:delete"})
    @RequestMapping("/admin/category-info/delete")
    @ResponseBody
    public String deleteCategory(Category category, Model model){
        if(categoryService.deleteCategory(category) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"category:view"})
    @RequestMapping("/admin/category-info/search")
    @ResponseBody
    public List<Category> searchCategory(Category category){
        System.out.println(category);
        List<Category> categoryList = categoryService.searchResult(category);
        System.out.println(categoryList);
        return categoryList;
    }
}

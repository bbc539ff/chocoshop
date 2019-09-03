package com.chocoshop.controller;

import com.chocoshop.model.Admin;
import com.chocoshop.service.AdminService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    // 管理员信息查看
    @RequestMapping("/admin/admin-info/index")
    public String adminInfo(){
        return "admin_info";
    }

    // 管理员信息查询（json）
    @RequestMapping("/admin/admin-info/list")
    @ResponseBody
    public Map<String, Object> adminList(int page, int rows){
        PageHelper.startPage(page, rows);
        List<Admin> categoryList = adminService.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("total", adminService.countAdmin());
        map.put("rows", categoryList);
        return map;
    }

    @RequestMapping("/admin/admin-info/add")
    @ResponseBody
    public String add(Admin admin){
        System.out.println(admin);
        if(adminService.addAdmin(admin) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/admin-info/update")
    @ResponseBody
    public String update(Admin admin, Model model){
        if(adminService.updateAdmin(admin) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/admin-info/delete")
    @ResponseBody
    public String delete(Integer adminId){
        Admin admin = new Admin();
        admin.setAdminId(adminId);
        if(adminService.deleteAdmin(admin) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/admin-info/search")
    @ResponseBody
    public List<Admin> searchCategory(Admin admin){
        System.out.println(admin);
        List<Admin> adminList = adminService.search(admin);
        System.out.println(adminList);
        return adminList;
    }


    // 主页面
    @RequestMapping("/admin/index")
    public String index(){
        return "index";
    }


    // 登录界面
    @RequestMapping(path = "/admin/login")
    public String login() {
        return "login";
    }

    // 登录失败处理
    @RequestMapping(path = "/admin/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Admin admin) {
        System.out.println("ctrl:login()"+admin);
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            System.out.println("exception=" + exception);
            System.out.println("error...");
        }
        return "index";
    }


    // 注册页面
    @RequestMapping("/admin/register")
    public String register() {
        return "register";
    }

    // 注册请求处理
    @RequestMapping(path = "/admin/register", method = RequestMethod.POST)
    public String register(Admin admin){
        adminService.addAdmin(admin);
        return "redirect:/admin/login";
    }


}

package com.chocoshop.controller;

import com.chocoshop.model.Admin;
import com.chocoshop.service.AdminService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/admin/add")
    @ResponseBody
    public String add(Admin admin){
        System.out.println(admin);
        if(adminService.addAdmin(admin) == 1){
            return "success";
        } else{
            return "error";
        }

    }

    @RequestMapping("/admin/delete")
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

    @RequestMapping("/admin/update")
    @ResponseBody
    public String update(Admin admin, Model model){
        if(adminService.updateAdmin(admin) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/admin/login")
    public String login(HttpServletRequest request, Admin admin) {
        System.out.println("ctrl:login()"+admin);
        String exception = (String) request.getAttribute("shiroLoginFailure");

        String msg = "";
        if (exception != null) {
            System.out.println("exception=" + exception);
            System.out.println("error...");
        }
        return "login";
    }


    @RequestMapping("/admin/register")
    public String register() {
        return "register";
    }


    @RequestMapping(path = "/admin/register", method = RequestMethod.POST)
    public String register(Admin admin){

        adminService.addAdmin(admin);
        return "redirect:/admin/login";
    }

    @RequestMapping("/admin/admin-info")
    public String adminInfo(){
        return "admin_info";
    }


    @RequestMapping("/admin/admin-list")
    @ResponseBody
    public List<Admin> adminList(int page, int rows){
        PageHelper.startPage(page, rows);
        List<Admin> adminList = adminService.findAll();

        return adminList;
    }


}

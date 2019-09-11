package com.chocoshop.controller;

import com.chocoshop.model.Admin;
import com.chocoshop.service.AdminService;
import com.chocoshop.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    SysRoleService sysRoleService;

    // 管理员信息查看
    @RequiresPermissions({"admin:view"})
    @RequestMapping("/admin/admin-info/index")
    public String adminInfo(){
        return "admin_info";
    }

    // 管理员信息查询（json）
    @RequestMapping("/admin/admin-info/list")
    @RequiresPermissions({"admin:view"})
    @ResponseBody
    public Map<String, Object> adminList(int page, int rows){
        PageHelper.startPage(page, rows);
        List<Admin> categoryList = adminService.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("total", adminService.countAdmin());
        map.put("rows", categoryList);
        return map;
    }

    @RequiresPermissions({"admin:view", "admin:add"})
    @RequestMapping("/admin/admin-info/add")
    @ResponseBody
    public String add(Admin admin, String roleId){
        System.out.println(admin);
        if(adminService.addAdmin(admin) == 1){
            sysRoleService.addRoleToAdmin(roleId, admin.getAdminId());
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"admin:view", "admin:update"})
    @RequestMapping("/admin/admin-info/update")
    @ResponseBody
    public String update(Admin admin, String roleId){
        if(adminService.updateAdmin(admin) == 1){
            sysRoleService.addRoleToAdmin(roleId, admin.getAdminId());
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"admin:view", "admin:delete"})
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

    @RequiresPermissions({"admin:view"})
    @RequestMapping("/admin/admin-info/search")
    @ResponseBody
    public List<Admin> searchCategory(Admin admin){
        System.out.println(admin);
        List<Admin> adminList = adminService.search(admin);
        System.out.println(adminList);
        return adminList;
    }


    // 主页面
    @RequestMapping({"/admin/index", "/"})
    public String index(HttpServletResponse response){
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        Integer adminId = admin.getAdminId();
        String adminName = admin.getAdminName();
        Cookie adminIdCookie = new Cookie("adminId", Integer.toString(adminId));
        Cookie adminNameCookie = new Cookie("adminName", adminName);
        response.addCookie(adminIdCookie);
        response.addCookie(adminNameCookie);
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

    @RequestMapping(path = "/admin/main")
    public String mainPage(){
        return "main";
    }
}

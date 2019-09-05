package com.chocoshop.controller;

import com.chocoshop.model.SysRole;
import com.chocoshop.service.SysPermissionService;
import com.chocoshop.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @RequiresPermissions({"role:view"})
    @RequestMapping("/admin/role-info/index")
    public String roleIndex(){
        return "role_info";
    }

    @RequiresPermissions({"role:view"})
    @RequestMapping("/admin/role-info/list")
    @ResponseBody
    public Map<String, Object> roleList(int page, int rows){
        Map<String, Object> map = new HashMap<>();
        try{
            PageHelper.startPage(page, rows);
            List<SysRole> sysRoleList = sysRoleService.showAllRole();

            map.put("total", sysRoleService.countSysRole());
            map.put("rows", sysRoleList);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @RequiresPermissions({"role:view", "role:update"})
    @RequestMapping("/admin/role-info/update")
    @ResponseBody
    public String updateSysRole(SysRole sysRole, String permIds){
        if(sysRoleService.updateSysRole(sysRole, permIds) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"role:view", "role:add"})
    @RequestMapping("/admin/role-info/add")
    @ResponseBody
    public String addSysRole(SysRole sysRole, String permIds){
        if(sysRoleService.addSysRole(sysRole, permIds) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"role:view", "role:delete"})
    @RequestMapping("/admin/role-info/delete")
    @ResponseBody
    public String deleteCategory(SysRole sysRole){
        if(sysRoleService.deleteSysRole(sysRole) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"role:view"})
    @RequestMapping("/admin/role-info/search")
    @ResponseBody
    public List<SysRole> search(SysRole sysRole){
        System.out.println(sysRole);
        List<SysRole> sysRoleList = sysRoleService.search(sysRole);
        System.out.println(sysRoleList);
        return sysRoleList;
    }
}

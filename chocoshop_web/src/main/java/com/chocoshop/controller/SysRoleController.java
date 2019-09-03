package com.chocoshop.controller;

import com.chocoshop.model.SysRole;
import com.chocoshop.service.SysRoleService;
import com.github.pagehelper.PageHelper;
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

    @RequestMapping("/admin/role-info/index")
    public String roleIndex(){
        return "role_info";
    }

    @RequestMapping("/admin/role-info/list")
    @ResponseBody
    public Map<String, Object> roleList(int page, int rows){
        Map<String, Object> map = new HashMap<>();
        try{
            PageHelper.startPage(page, rows);
            List<SysRole> sysRoleList = sysRoleService.showAllRole();

            map.put("total", sysRoleList.size());
            map.put("rows", sysRoleList);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/admin/role-info/update")
    @ResponseBody
    public String updateSysRole(SysRole sysRole){
        if(sysRoleService.updateSysRole(sysRole) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/role-info/add")
    @ResponseBody
    public String addSysRole(SysRole sysRole, List<Integer> permId){
        if(sysRoleService.addSysRole(sysRole) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/role-info/delete")
    @ResponseBody
    public String deleteCategory(SysRole sysRole){
        if(sysRoleService.deleteSysRole(sysRole) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping("/admin/role-info/search")
    @ResponseBody
    public List<SysRole> search(SysRole sysRole){
        System.out.println(sysRole);
        List<SysRole> sysRoleList = sysRoleService.search(sysRole);
        System.out.println(sysRoleList);
        return sysRoleList;
    }
}

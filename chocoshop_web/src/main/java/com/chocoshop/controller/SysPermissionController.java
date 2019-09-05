package com.chocoshop.controller;

import com.chocoshop.model.SysPermission;
import com.chocoshop.service.SysPermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SysPermissionController {

    @Autowired
    SysPermissionService sysPermissionService;

    @RequiresPermissions({"perm:view"})
    @RequestMapping("/admin/perm-info/list")
    @ResponseBody
    public List<SysPermission> SysPermissionList(){
        return sysPermissionService.findAll();
    }
}

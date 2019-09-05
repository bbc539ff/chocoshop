package com.chocoshop.controller;

import com.chocoshop.model.Member;
import com.chocoshop.service.MemberService;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import utils.Utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MemberController {
    @Autowired
    public MemberService memberService;

    @RequiresPermissions({"member:view"})
    @GetMapping("/admin/member-info/list")
    @ResponseBody
    public Map<String, Object> showAllGoods(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Member> memberList = memberService.showAllMembers();
        Map<String, Object> map = new HashMap<>();
        map.put("total", memberService.countMember());
        map.put("rows", memberList);
        return map;
    }

    @RequiresPermissions({"member:view"})
    @RequestMapping("/admin/member-info/index")
    public String showGoodsPage() throws IOException {
        return "member_info";
    }

    @RequiresPermissions({"member:view", "member:add"})
    @RequestMapping("/admin/member-info/add")
    @ResponseBody
    public String add(Member member, @RequestParam("file") MultipartFile file) throws FileNotFoundException {

        try{
            if(memberService.addMember(member, file) == 1){
                return "success";
            } else {
                return "error";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @RequiresPermissions({"member:view", "member:update"})
    @RequestMapping("/admin/member-info/update")
    @ResponseBody
    public String update(Member member, @RequestParam("file") MultipartFile file) throws FileNotFoundException {

        if(memberService.updateMember(member, file) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"member:view", "member:delete"})
    @RequestMapping("/admin/member-info/delete")
    @ResponseBody
    public String delete(String memberUuid){
        Member member = new Member();
        member.setMemberUuid(memberUuid);
        if(memberService.deleteMember(member) == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequiresPermissions({"member:view"})
    @RequestMapping("/admin/member-info/search")
    @ResponseBody
    public List<Member> search(Member member){
        System.out.println(member);
        List<Member> memberList = memberService.search(member);
        System.out.println(memberList);
        return memberList;
    }
}

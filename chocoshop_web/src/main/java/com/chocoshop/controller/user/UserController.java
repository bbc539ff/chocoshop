package com.chocoshop.controller.user;

import com.chocoshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/user/login")
    public String login(){
        return "/user/login";
    }

    @RequestMapping("/user/index")
    public String index(){
        return "/user/index";
    }

    @RequestMapping("/user/navbar")
    public String navbar(){
        return "/user/navbar";
    }


}

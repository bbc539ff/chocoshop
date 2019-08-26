package com.chocoshop.controller;

import com.chocoshop.model.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @GetMapping({"/", "index"})
    public String index(){
        return "index";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request, UserInfo user) {
        System.out.println(user);
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            System.out.println("error...");
        }
        return "login";
    }


}

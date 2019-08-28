package com.chocoshop.controller;

import com.chocoshop.model.UserInfo;
import com.chocoshop.service.UserInfoService;
import com.chocoshop.utils.Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 主页面
     * @return
     */
    @GetMapping({"/", "index"})
    public String index(){
        return "index";
    }

    /**
     * 登录页面（只处理失败情况）
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, UserInfo user) {
        System.out.println(user);
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            System.out.println("error...");
        }
        return "/login";
    }

    /**
     * 用户注册页面
     * @param
     * @return
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 提交注册表单
     * @param userInfo
     * @return
     */
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(UserInfo userInfo){
        System.out.println(userInfo);
        String pwd = userInfo.getPassword();
        String salt = Utils.generateSalt(pwd);
        String new_pwd = Utils.generatePwd(pwd, salt);
        userInfo.setSalt(salt);
        userInfo.setPassword(new_pwd);
        userInfo.setState(false); // 默认为不可用
        userInfo.setCreated(new Date());
        userInfo.setUpdated(new Date());

        userInfoService.createUser(userInfo);
        return "redirect:/login";
    }

    /**
     * 用户详细信息页面
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("/userinfo/{username}")
    public String showUserInfo(@PathVariable String username, Model model){
        UserInfo userinfo = userInfoService.findByUsername(username);
        System.out.println(userinfo);
        model.addAttribute("userinfo", userinfo);
        return "userinfo";
    }
}

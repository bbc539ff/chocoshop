package com.chocoshop.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@Controller
public class KaptchaController {
    @Autowired
    DefaultKaptcha defaultKaptcha;

    @RequestMapping(path = "/img/kaptcha-image", produces = {"image/jpeg"})
    public ModelAndView defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{

        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        httpServletResponse.addHeader("Cache-Control", "post-check=0, pre-check=0");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setContentType("image/jpeg");
        String capText = defaultKaptcha.createText();
        httpServletRequest.getSession().setAttribute("verifyCode", capText);
        BufferedImage bi = defaultKaptcha.createImage(capText);
        System.out.println(capText);
        ServletOutputStream out = httpServletResponse.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }
}
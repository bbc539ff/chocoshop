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
//        byte[] captchaChallengeAsJpeg = null;
//        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
//        try {
//            //生产验证码字符串并保存到session中
//            String createText = defaultKaptcha.createText();
//            httpServletRequest.getSession().setAttribute("verifyCode", createText);
//            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
//            BufferedImage challenge = defaultKaptcha.createImage(createText);
//            System.out.println(createText);
//            ImageIO.write(challenge, "jpg", jpegOutputStream);
//        } catch (IllegalArgumentException e) {
//            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
//            return;
//        }
//
//        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
//        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
//        httpServletResponse.setHeader("Cache-Control", "no-store");
//        httpServletResponse.setHeader("Pragma", "no-cache");
//        httpServletResponse.setDateHeader("Expires", 0);
//        httpServletResponse.setContentType("image/jpeg");
//        ServletOutputStream responseOutputStream =
//                httpServletResponse.getOutputStream();
//        responseOutputStream.write(captchaChallengeAsJpeg);
//        responseOutputStream.flush();
//        responseOutputStream.close();
        httpServletResponse.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        httpServletResponse.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        httpServletResponse.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        httpServletResponse.setHeader("Pragma", "no-cache");
        // return a jpeg
        httpServletResponse.setContentType("image/jpeg");
        // create the text for the image
        String capText = defaultKaptcha.createText();
        // store the text in the session
        httpServletRequest.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // create the image with the text
        BufferedImage bi = defaultKaptcha.createImage(capText);
        System.out.println(capText);
        ServletOutputStream out = httpServletResponse.getOutputStream();
        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }
}
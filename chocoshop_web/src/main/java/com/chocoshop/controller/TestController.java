package com.chocoshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class TestController {

    @RequestMapping("/upload")
    public String upload(){
        return "upload";
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, String username){
        System.out.println(username);
        if(file.isEmpty()) {
            return null;
        }
        String UPLOAD_FOLDER = request.getContextPath() + "/upload/";
        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            System.out.println(path.toAbsolutePath().toString());

            Files.write(path, bytes);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "upload";
    }
}

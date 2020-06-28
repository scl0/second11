package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class MyController {
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, HttpServletResponse response, MultipartFile pic) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/files");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        String fimeName = pic.getOriginalFilename();
        pic.transferTo(new File(file,fimeName));
        System.out.println("上传文件");
        return null;
    }
}

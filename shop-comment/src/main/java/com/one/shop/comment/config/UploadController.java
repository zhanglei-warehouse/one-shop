package com.one.shop.comment.config;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile file) {
        //文件上传
        if (file != null && !file.isEmpty()) {
            //获取文件的原始名称
            String fileOriginalFilename = file.getOriginalFilename();
            //拼接一个新名称
            String fileName = UUID.randomUUID() + "_" + fileOriginalFilename;
            //保存的文件地址
            File destFile = new File("E:\\zhuanji\\实训一\\pic", fileName);

            try {
                //执行保存
                file.transferTo(destFile);
                //头像保存的地址
                String imgurl="http://localhost:/img/" + fileName;
                return imgurl;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "图片上传错误";
    }
}

package com.kroly.centre.controller;

import com.alibaba.fastjson.JSONObject;
import com.kroly.centre.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.Executor;

/**
 * @ClassName LoggerController
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-08-16 16:21
 **/
@RestController
public class LoggerController {


    @Autowired
    private LoggerService loggerService;

    @Resource(name = "taskExecutor")
    private Executor executor;


    @RequestMapping("/test")
    public void test(String sid){
        executor.execute(()->loggerService.test(sid));
    }

    @RequestMapping("/upload")
    public Object view(MultipartFile file) throws Exception {
        String url = "/Users/xmly/Desktop/1.jpg";
        File file1 = new File(url);
        if (!file1.exists()){
            file1.createNewFile();
        }
        file.transferTo(file1);
        return "success";

    }
}

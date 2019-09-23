package com.kroly.centre.controller;

import com.kroly.centre.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}

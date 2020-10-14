package com.centre.loop.controller;

import com.centre.loop.service.Handler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PortController
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/9
 * @Version 1.0
 **/
@RestController
public class PortController {

    @Resource(name = "ioHandler")
    private Handler ioHandler;

    @RequestMapping(value = "/ioTest", method = RequestMethod.GET)
    public void ioTest(){
        ioHandler.process();
    }

}

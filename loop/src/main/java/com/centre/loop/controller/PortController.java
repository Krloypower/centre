package com.centre.loop.controller;

import com.centre.loop.service.Handler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PortController
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/9
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PortController {


    @Autowired
    private Map<String, Handler> handlerMap;

    @RequestMapping(value = "/oom", method = RequestMethod.GET)
    public void ioTest(String handler) {
        Handler hand = handlerMap.get(handler);
        log.info("hand={}", hand);
        if (hand != null) {
            hand.process();
        }
    }

}

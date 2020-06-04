package com.kroly.centre.annotation.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-28 18:24
 **/
@Component
public class Main {

    @Cache(value = "cacheKang")
    public String test(){
        // do someThing
        return "kang";
    }
}

package com.kroly.centre.annotation.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName SomeThing
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-04-23 18:31
 **/
@Component
@AliasTest(key = "11")
public class SomeThing {

    @DoOpen
    public void doSome(){
        System.out.println("do something");
    }

}

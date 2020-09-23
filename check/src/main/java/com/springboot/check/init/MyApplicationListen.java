package com.springboot.check.init;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName MyApplicationListen
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/9/21
 * @Version 1.0
 **/
public class MyApplicationListen implements ApplicationListener<ApplicationEvent> {

    public MyApplicationListen() {
        System.out.println("MyApplicationListen init");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.toString());
    }
}

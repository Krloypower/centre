package com.springboot.check.init;

import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName MyApplicationContextInitializedEventListen
 * @Description 监听器顺序 3
 * @Author ouyangkang
 * @Date 2020/9/23
 * @Version 1.0
 **/
public class MyApplicationContextInitializedEventListen implements ApplicationListener<ApplicationContextInitializedEvent> {

    public MyApplicationContextInitializedEventListen() {
        System.out.println("MyApplicationContextInitializedEventListen init");
    }

    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent event) {
        System.out.println("MyApplicationContextInitializedEventListen  process........" + event.toString());
    }
}

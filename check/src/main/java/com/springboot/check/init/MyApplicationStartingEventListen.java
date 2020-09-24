package com.springboot.check.init;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName ApplicationStartingEventListen
 * @Description 监听器顺序1
 * @Author ouyangkang
 * @Date 2020/9/23
 * @Version 1.0
 **/
public class MyApplicationStartingEventListen implements ApplicationListener<ApplicationStartingEvent> {

    public MyApplicationStartingEventListen() {
        System.out.println("ApplicationStartingEventListen init");
    }

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("MyApplicationStartingEventListen  process........" + event.toString());
    }
}

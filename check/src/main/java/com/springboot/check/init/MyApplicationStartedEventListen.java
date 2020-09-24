package com.springboot.check.init;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName MyApplicationStartedEventListen
 * @Description 监听器顺序 5
 * @Author ouyangkang
 * @Date 2020/9/23
 * @Version 1.0
 **/
public class MyApplicationStartedEventListen implements ApplicationListener<ApplicationStartedEvent> {
    public MyApplicationStartedEventListen() {
        System.out.println("MyApplicationStartedEventListen init");
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("MyApplicationStartedEventListen  process........" + event.toString());

    }
}

package com.springboot.check.init;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName ApplicationStartingEventListen
 * @Description 监听器顺序 2
 * @Author ouyangkang
 * @Date 2020/9/23
 * @Version 1.0
 **/
public class MyApplicationEnvironmentPreparedEventListen implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    public MyApplicationEnvironmentPreparedEventListen() {
        System.out.println("ApplicationEnvironmentPreparedEvent init");
    }

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        System.out.println("ApplicationEnvironmentPreparedEvent  process........" + event.toString());
    }
}

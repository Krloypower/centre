package com.springboot.check.init;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

/**
 * @ClassName MyApplicationPreparedEventListen
 * @Description 监听器顺序 4
 * @Author ouyangkang
 * @Date 2020/9/23
 * @Version 1.0
 **/
public class MyApplicationPreparedEventListen implements ApplicationListener<ApplicationPreparedEvent> {

    public MyApplicationPreparedEventListen() {
        System.out.println("MyApplicationPreparedEventListen  init");
    }

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        System.out.println("MyApplicationPreparedEventListen  process........" + event.toString());

    }

}

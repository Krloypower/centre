package com.springboot.check.init;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyApplicationListen
 * @Description ALL
 * @Author ouyangkang
 * @Date 2020/9/21
 * @Version 1.0
 **/
public class MyApplicationListen implements ApplicationListener<ApplicationEvent> , Ordered {

    public MyApplicationListen() {
        System.out.println("MyApplicationListen init");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationListen process....."+event.toString());

        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            onApplicationEnvironmentPreparedEvent((ApplicationEnvironmentPreparedEvent) event);
        }
    }

    private void onApplicationEnvironmentPreparedEvent(ApplicationEnvironmentPreparedEvent environmentPreparedEvent){
        ConfigurableEnvironment environment = environmentPreparedEvent.getEnvironment();
        Map<String, Object> map = new HashMap<>();
        map.put("server.port","8088");
        map.put("spring.application.name","ouyang");
        MapPropertySource mapPropertySource = new MapPropertySource("portWrite", map);
        environment.getPropertySources().addFirst(mapPropertySource);

        String property = environment.getProperty("server.port");
        String name = environment.getProperty("spring.application.name");
        System.out.println("property="+property);
        System.out.println("name="+name);
        System.out.println("onApplicationEnvironmentPreparedEvent event");
    }


    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 11;
    }
}

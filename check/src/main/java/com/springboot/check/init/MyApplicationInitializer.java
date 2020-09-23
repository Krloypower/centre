package com.springboot.check.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName MyApplicationInitializer
 * @Description springboot 项目初始化
 * @Author ouyangkang
 * @Date 2020/9/21
 * @Version 1.0
 **/
public class MyApplicationInitializer  implements ApplicationContextInitializer {
    public MyApplicationInitializer() {
        System.out.println("MyApplicationInitializer init");
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("MyApplicationInitializer initialize");
    }
}

package com.kroly.centre.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName Student
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-05-22 10:31
 **/
public class Student implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean, ApplicationContextAware {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware .....");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware .....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean....");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware......");
    }
}

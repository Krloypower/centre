package com.kroly.centre.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @ClassName MyBeanFactoryPostProcessor
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-05-22 10:45
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("这是BeanFactoryPostProcessor实现类构造器！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        BeanDefinition student = configurableListableBeanFactory.getBeanDefinition("student");
        MutablePropertyValues propertyValues = student.getPropertyValues();
        System.out.println(propertyValues);
    }
}

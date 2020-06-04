package com.kroly.centre.annotation;

import com.kroly.centre.annotation.service.AliasTest;
import com.kroly.centre.annotation.service.Main;
import com.kroly.centre.annotation.service.SomeThing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @ClassName AnnotationTest
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-05-28 10:19
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class AnnotationTest {
    @Autowired
    private SomeThing someThing;

    @Autowired
    private Main main;

    @Test
    public void aliasTest(){
        System.out.println( main.test());
//        RequestMapping annotation = someThing.getClass().getAnnotation(RequestMapping.class);
//        if (annotation != null){
//            System.out.println(annotation.annotationType());
//        }
    }
}

package com.kroly.centre.annotation.service;

import java.lang.reflect.Method;

/**
 * @ClassName OpenService
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-04-23 18:37
 **/
public class OpenService {

    public void doOpen() throws Exception {
        System.out.println("OpenService----doOpen");
        Class<SomeThing> someThingClass = SomeThing.class;
        Method[] methods = someThingClass.getDeclaredMethods();
        Method doOpen =  null;
        for (Method method : methods){

            if (method.getAnnotation(DoOpen.class) != null){
                doOpen = method;
            }
        }

        doOpen.invoke(someThingClass.getDeclaredConstructor().newInstance());
    }
}

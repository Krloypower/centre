package com.kroly.centre.annotation.service;

import java.lang.annotation.*;

/**
 * @InterfaceName Cache
 * @Description TODO
 * @Author kang.ouyang
 * @Date 2020-05-29 11:36
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    String value() default "";
}

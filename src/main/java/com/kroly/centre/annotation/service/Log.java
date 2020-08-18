package com.kroly.centre.annotation.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author ouyangkang
 * @Description 打印方式执行时间，实现类LogAspect
 * @Date 2020/7/28
 * @return: null
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
}

package com.kroly.centre.annotation.service;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AliasTest {

    @AliasFor("key")
    String value() default "";

    @AliasFor("value")
    String key() default "";
}

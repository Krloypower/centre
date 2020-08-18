package rubbish.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName rubbish.Reflect
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-28 18:15
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Reflect {
    String name() default "ouyangkang";
}

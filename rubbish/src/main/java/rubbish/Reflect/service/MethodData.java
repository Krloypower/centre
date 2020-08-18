package rubbish.Reflect.service;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName MethodData
 * @Description 类中方法的操作
 * @Author ouyangkang
 * @Date 2019-05-29 10:40
 **/
@Component
public class MethodData {

    public <T> void testMethodInvoke(Class<T> clazz) throws Exception{
        T t = clazz.newInstance();

        Method method1 = clazz.getMethod("setName", String.class);
        method1.invoke(t,"ouyangkang method test");

        //getMethod(name,parameterTypes)
        // name ：方法的名字
        //parameterTypes : 方法参数类型的Class类型。没有就不填
        Method method = clazz.getMethod("getName");
        // 调用 getName 这个方法
        //
        System.out.println(method.invoke(t));

    }
}

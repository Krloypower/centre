package rubbish.service;

import java.lang.reflect.Method;

/**
 * @ClassName ReflectProcessor
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-28 18:20
 **/
public class ReflectProcessor {

    @Reflect
    public void sayHello(String name){
        System.out.println(name);
    }

    @Reflect(name = "kang.ouyang")
    public void styName(String name){
        System.out.println(name);
    }

    public void parseMethod(final Class<?> clazz) throws Exception{
        Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            Reflect reflect = method.getAnnotation(Reflect.class);
            if (null != reflect){
                method.invoke(obj,reflect.name());
            }
        }
    }
}

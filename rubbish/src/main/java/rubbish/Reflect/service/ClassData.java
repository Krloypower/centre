package rubbish.Reflect.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @ClassName ClassData
 * @Description 类对象  获取类对象的数据
 * @Author ouyangkang
 * @Date 2019-05-29 10:12
 **/
@Component
@Lazy
public class ClassData {

    /**
     * @Author ouyangkang
     * @Description 获取对象
     * @Date 10:22 2019-05-29
     * @param clazz
     * @return void
    **/
    public <T> void testClassInstance(Class<T> clazz) throws Exception{
        T t = clazz.newInstance();
    }

    /**
     * @Author ouyangkang
     * @Description 获取构参数
     * @Date 10:26 2019-05-29
     * @param clazz
     * @return void
    **/
    public <T> void testClassConStructor(Class<T> clazz) throws Exception {
        Constructor<T> constructor = clazz.getConstructor(String.class, Integer.class);
        // 用有参数的构造方法 新建对象
        T ouyangkang = constructor.newInstance("ouyangkang", 20);
        System.out.println(ouyangkang);

        // 获取所有构造参数
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor constructor1 : constructors){
            Class[] types = constructor1.getParameterTypes();
            for (Class type : types){
                System.out.print(type.getName());
            }
            System.out.println("");
        }
    }

    /**
     * @Author ouyangkang
     * @Description 对类的属性进行修改 私有 或者公开的
     * @Date 10:39 2019-05-29
     * @param clazz
     * @return void
    **/
    public <T> void testClassField(Class<T> clazz) throws Exception{
        T t = clazz.newInstance();
        // 获取私有的 类里面的 属性
        Field name = clazz.getDeclaredField("name");
        // 允许对私有的属性进行操作
        name.setAccessible(true);

        name.set(t,"oyk");
        System.out.println(t);
    }
}

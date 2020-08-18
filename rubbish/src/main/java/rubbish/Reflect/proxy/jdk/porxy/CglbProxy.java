package rubbish.Reflect.proxy.jdk.porxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglbProxy
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-29 11:13
 **/
public class CglbProxy implements MethodInterceptor {

    private Object traget;

    public Object createProxy(Object obj){
        this.traget = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        return proxy;

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj =  null;
        checkPopedom();
        obj = method.invoke(traget,objects);
        return obj;
    }

    private void checkPopedom() {
        System.out.println(".:检查权限  checkPopedom()!");
    }
}

package com.kroly.centre.Reflect.proxy.jdk.porxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JdkProxy
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-29 11:09
 **/
public class JdkProxy implements InvocationHandler {

    // 需要代理的对象
    private Object target;

    public Object newProxy(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        check();
        Object ret = null;// 设置方法的返回值
        ret = method.invoke(target,args);
        return ret;
    }

    // 模拟检查权限
    private void check(){
        System.out.println("检查权限。。。 没问题");
    }
}

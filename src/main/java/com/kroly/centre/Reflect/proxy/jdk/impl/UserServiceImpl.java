package com.kroly.centre.Reflect.proxy.jdk.impl;

import com.kroly.centre.Reflect.dto.User;
import com.kroly.centre.Reflect.proxy.jdk.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-29 11:07
 **/
public class UserServiceImpl implements UserService {
    @Override
    public void setUser(String name, Integer age) {
        System.out.println("设置 user name=" + name + " age="+age);
    }

    @Override
    public User getUser() {
        return new User("ouyang",21);
    }
}

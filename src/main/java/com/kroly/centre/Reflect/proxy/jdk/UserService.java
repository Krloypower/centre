package com.kroly.centre.Reflect.proxy.jdk;

import com.kroly.centre.Reflect.dto.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-29 11:06
 **/
public interface UserService {

    void setUser(String name,Integer age);

    User getUser();
}

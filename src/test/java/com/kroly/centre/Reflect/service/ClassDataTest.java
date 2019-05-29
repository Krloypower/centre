package com.kroly.centre.Reflect.service;

import com.kroly.centre.CentreApplicationTests;
import com.kroly.centre.Reflect.dto.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ClassDataTest extends CentreApplicationTests {

    @Autowired
    ClassData classData;

    Class<User> clazz;

    @Before
    public void before(){
        clazz = (Class<User>) new User().getClass();
    }

    @Test
    public void testClassInstance() {
        try {
            classData.testClassInstance(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClassConStructor() {
        try {
            classData.testClassConStructor(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClassField() throws Exception {
        classData.testClassField(clazz);
    }
}
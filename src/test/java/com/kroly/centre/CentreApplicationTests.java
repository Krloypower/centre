package com.kroly.centre;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CentreApplicationTests {

    @Test
    public void contextLoads() throws  Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        Class<? extends List> listClass = list.getClass();
        Method method = listClass.getMethod("add", Object.class);
        method.invoke(list,"ouyangkang");
        System.out.println(list);
    }

}

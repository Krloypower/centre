package com.kroly.centre;

import com.kroly.centre.asyn.AsynTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName AsynForTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-08-05 18:09
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsynForTest {

    @Autowired
    private AsynTest asynTest;

    @Test
    public void test(){
        List<String> list = new ArrayList<>();


        List<String> a = new ArrayList<>();
        a.stream().collect(Collectors.toList());
        a.add("o");
        a.add("e");
        list.addAll(a);

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("a") || s.equals("d")){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
        System.out.println("结束");
//        asynTest.test();
    }
}

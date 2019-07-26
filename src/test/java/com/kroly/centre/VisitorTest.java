package com.kroly.centre;

import com.kroly.centre.visitor.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName VisitorTest
 * @Description 访问者模式
 * @Author ouyangkang
 * @Date 2019-07-19 11:14
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class VisitorTest {

    @Test
    public void test(){
        CarCompant car = new Car();
        Mechanic mechanic = new NonQualifiedMechanic();
        car.acpect(mechanic);
        System.out.println(car.getBroken());
    }
}

package com.kroly.centre.asyn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName AsynTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-08-05 18:02
 **/
@Component
@Slf4j
public class AsynTest {

    @Autowired
    Asyn1 asyn1;

    public void test(){
        asyn1.test1();
        asyn1.test2();
    }

    @Component
    class Asyn1{
        @Async("taskExecutor")
        public void test1(){
            log.info("test1=[{}]",Thread.currentThread());
        }

        @Async("taskExecutor")
        public void test2(){
            log.info("test2=[{}]",Thread.currentThread());
        }
    }


}

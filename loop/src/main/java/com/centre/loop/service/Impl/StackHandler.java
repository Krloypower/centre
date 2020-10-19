package com.centre.loop.service.Impl;

import com.centre.loop.service.Handler;
import org.springframework.stereotype.Service;

/**
 * @ClassName StackHandler
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/15
 * @Version 1.0
 **/
@Service("stackHandler")
public class StackHandler implements Handler {


    private int i = 0;

    @Override
    public void process() {
        stackTest();
    }

    private void stackTest(){
        i++;
        stackTest();
    }
}

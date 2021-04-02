package com.centre.book.并发编程的艺术.第三章;

import org.springframework.util.ObjectUtils;

/**
 * @ClassName FinalDemo
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/3/30
 * @Version 1.0
 **/
public class FinalDemo {
    int i;
    final int j;
    static FinalDemo obj;

    public FinalDemo(){
        i = 1;
        j = 2;
    }

    public static void write(){
        obj = new FinalDemo();

    }

    public static void read(){
        FinalDemo object  = obj;
        int a = object.i;
        int b = object.j;
    }
}

package com.centre.book.并发编程的艺术.第三章;

/**
 * @ClassName FinalReferenceDemo
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/3/30
 * @Version 1.0
 **/
public class FinalReferenceDemo {
    final int[] array;
    static FinalReferenceDemo obj;

    public FinalReferenceDemo(){
        array = new int[1];
        array[0] = 1;
    }

    public static void writeOne(){
        obj = new FinalReferenceDemo();
    }
    public static void writeTwo(){
        obj.array[0] = 2;
    }
    public static void read(){
        if (obj != null){
            int temp = obj.array[0];
        }
    }
}

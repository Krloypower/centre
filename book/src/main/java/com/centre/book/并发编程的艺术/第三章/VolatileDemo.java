package com.centre.book.并发编程的艺术.第三章;

/**
 * @ClassName VolatileDemo
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/3/16
 * @Version 1.0
 **/
public class VolatileDemo {

    private volatile boolean flag = false;

    private int i = 0;

    public void write() {
        System.out.println("write--");
        i = 1;
        flag = true;



    }

    public void read() {
        System.out.println("start---");
        if (flag) {
            int a = i;
            System.out.println(a);
        }
        System.out.println("end---");
    }

    public static void main(String[] args) {
        VolatileDemo demo = new VolatileDemo();
        Thread thread = new Thread(() -> {
            demo.write();
        });

        Thread thread2 = new Thread(() -> {
            demo.read();
        });

        thread.start();
        thread2.start();
    }
}

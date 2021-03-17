package com.centre.book.并发编程的艺术.第三章;

/**
 * @ClassName MonitorDemo
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/3/17
 * @Version 1.0
 **/
public class MonitorDemo {

    private int i = 0;

    public synchronized void write(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
    }

    public synchronized void read(){
        int a = i;
        System.out.println(a);
    }

    public static void main(String[] args) {
        MonitorDemo monitorDemo = new MonitorDemo();
        Thread write = new Thread(()->{
            monitorDemo.write();
        });

        Thread read = new Thread(()->{
            monitorDemo.read();
        });
        write.start();
        read.start();
    }
}

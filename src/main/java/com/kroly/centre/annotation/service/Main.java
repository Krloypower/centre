package com.kroly.centre.annotation.service;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-28 18:24
 **/
public class Main {

    @Reflect
    public static void sayHello(String name){
        System.out.println(name);
    }

    @Reflect(name = "oyk")
    public static void styName(String name){
        System.out.println(name);
    }

    public static void main(String[] args) throws Exception {
        ReflectProcessor processor = new ReflectProcessor();
        processor.parseMethod(Main.class);
    }
}

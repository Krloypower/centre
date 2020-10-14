package com.centre.design.adapter;

/**
 * @ClassName AdapterTest
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/14
 * @Version 1.0
 **/
public class AdapterTest {

    public static void main(String[] args) {
        HolderMaker holeMaker = new HoleMakerImpl();
        holeMaker.makeHole(9);
        holeMaker.makeHole(5);
        holeMaker.makeHole(4);
        holeMaker.makeHole(12);
    }
}

package com.kroly.centre.designpattern.builder;

/**
 * @ClassName Bottle
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 10:32
 **/
public class Bottle implements Packing {
    @Override
    public String packing() {
        return "Bottle";
    }
}

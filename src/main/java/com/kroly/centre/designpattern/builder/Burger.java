package com.kroly.centre.designpattern.builder;

/**
 * @ClassName Burger
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 10:33
 **/
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Warpper();
    }

    @Override
    public abstract float price();
}

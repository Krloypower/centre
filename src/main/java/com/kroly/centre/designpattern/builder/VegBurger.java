package com.kroly.centre.designpattern.builder;

/**
 * @ClassName VegBurger
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 10:38
 **/
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}

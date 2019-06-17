package com.kroly.centre.designpattern.builder;

/**
 * @ClassName ChickenBurger
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 11:20
 **/
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 55.5f;
    }
}

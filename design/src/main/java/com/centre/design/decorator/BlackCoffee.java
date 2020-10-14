package com.centre.design.decorator;

/**
 * @ClassName BlackCoffee
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/13
 * @Version 1.0
 **/
public class BlackCoffee extends Coffee {

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int makeMoreCandied() {
        return 0;
    }
}

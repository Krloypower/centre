package com.centre.design.decorator;

/**
 * @ClassName SugarCoffee
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/13
 * @Version 1.0
 **/
public class SugarCoffee extends CoffeeDecorator {
    public SugarCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int makeMoreCandied() {
        return super.makeMoreCandied() + 1;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 3;
    }
}

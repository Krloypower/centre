package com.centre.design.decorator;

/**
 * @ClassName MilkCoffee
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/13
 * @Version 1.0
 **/
public class MilkCoffee extends CoffeeDecorator {
    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int makeMoreCandied() {
        return super.makeMoreCandied() + 1;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}

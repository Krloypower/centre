package com.centre.design.decorator;

/**
 * @ClassName CoffeeDecorator
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/13
 * @Version 1.0
 **/
public abstract class CoffeeDecorator extends Coffee {

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public int makeMoreCandied() {
        return this.coffee.makeMoreCandied();
    }

    @Override
    public int getPrice() {
        return this.coffee.getPrice();
    }
}

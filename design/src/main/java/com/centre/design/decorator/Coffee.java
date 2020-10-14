package com.centre.design.decorator;

import lombok.ToString;

/**
 * @ClassName Coffee
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/13
 * @Version 1.0
 **/
@ToString
public abstract class Coffee {
    protected int candied = 0;
    protected int price = 2;

    public abstract int makeMoreCandied();

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price += price;
    }
}

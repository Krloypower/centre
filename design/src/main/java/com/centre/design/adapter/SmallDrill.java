package com.centre.design.adapter;

/**
 * @ClassName SmallDrill
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/14
 * @Version 1.0
 **/
public class SmallDrill implements Drillbit {
    @Override
    public void makeSmall() {
        System.out.println("SmallDrill makeSmall");
    }

    @Override
    public void makeBig() {

    }
}

package com.centre.design.adapter;

/**
 * @ClassName BigDrill
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/14
 * @Version 1.0
 **/
public class BigDrill implements Drillbit {
    @Override
    public void makeSmall() {

    }

    @Override
    public void makeBig() {
        System.out.println("BigDrill makeBig");
    }
}

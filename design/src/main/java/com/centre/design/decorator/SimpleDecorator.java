package com.centre.design.decorator;

/**
 * @ClassName SimpleDecorator
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/13
 * @Version 1.0
 **/
public class SimpleDecorator {
    public static void main(String[] args) {
        Coffee sugarMilkCoffer = new MilkCoffee(new SugarCoffee(new BlackCoffee()));
        System.out.println(sugarMilkCoffer.getPrice());
        System.out.println(sugarMilkCoffer.makeMoreCandied());
    }
}

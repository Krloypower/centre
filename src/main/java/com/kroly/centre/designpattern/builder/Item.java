package com.kroly.centre.designpattern.builder;

/**
 * @InterfaceName Item
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 10:30
 **/
public interface Item {
    String name();
    Packing packing();
    float price();
}

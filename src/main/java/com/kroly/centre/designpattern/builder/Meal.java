package com.kroly.centre.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Meal
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 11:22
 **/
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float cost(){
        float sum = 0f;
        for (Item item : items){
            sum += item.price();
        }
        return sum;
    }

    public void show(){
        for (Item item : items){
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().packing());
            System.out.println(", Price : "+item.price());
        }
    }
}

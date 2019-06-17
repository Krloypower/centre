package com.kroly.centre.designpattern.builder;

/**
 * @ClassName MealBuilder
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 11:26
 **/
public class MealBuilder {
    public Meal prepareVelMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

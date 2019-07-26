package com.kroly.centre.onjava8.第六章;

/**
 * @ClassName Rock
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-22 10:05
 **/
public class Rock {
    Rock(){
        System.out.println("rock");
    }

    public static void main(String[] args) {
        long a = 1;
        double b= 1;
        float c = 1;
        for (int i = 0; i < 10; i++) {
            new Rock();
        }
    }
}


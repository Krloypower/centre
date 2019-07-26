package com.kroly.centre.onjava8.第十三章;

import java.util.function.Function;

/**
 * @ClassName RecursiveFibonacci
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-26 10:53
 **/
public class RecursiveFibonacci {
    Function<Integer,Integer> function;

    public RecursiveFibonacci(){
        function = n -> n == 0 ? 0:
                n==1 ? 1 : function.apply(n-1) + function.apply(n-2);
    }

    int fibonacci(int i){
        return function.apply(i);
    }

    public static void main(String[] args) {
        RecursiveFibonacci recursiveFibonacci = new RecursiveFibonacci();
        for (int i = 0; i < 9; i++) {
            System.out.println(recursiveFibonacci.fibonacci(i));

        }
    }
}

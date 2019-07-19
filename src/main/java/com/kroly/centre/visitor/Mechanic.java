package com.kroly.centre.visitor;

/**
 * @ClassName Mechanic
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-19 11:02
 **/
public interface Mechanic {
    void visit(CarCompant carCompant);
    String getName();
}

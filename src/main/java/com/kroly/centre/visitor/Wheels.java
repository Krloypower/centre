package com.kroly.centre.visitor;

/**
 * @ClassName Wheels
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-19 11:01
 **/
public class Wheels extends CarCompant {
    @Override
    public void acpect(Mechanic mechanic) {
        mechanic.visit(this);
    }
}

package com.centre.design.adapter;

/**
 * @ClassName HoleMakerImpl
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/14
 * @Version 1.0
 **/
public class HoleMakerImpl implements HolderMaker {
    @Override
    public void makeHole(int diameter) {
        Drill drill = new Drill(diameter);
        drill.makeHole(diameter);
    }
}

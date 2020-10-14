package com.centre.design.adapter;

/**
 * @ClassName Drill
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/14
 * @Version 1.0
 **/
public class Drill implements HolderMaker {
    Drillbit drillbit;

    public Drill(int diameter) {
        this.drillbit = getDrill(diameter);
    }

    @Override
    public void makeHole(int diameter) {
        if (isbig(diameter)){
            drillbit.makeBig();
        }else {
            drillbit.makeSmall();
        }
    }

    private boolean isbig(int diameter){
        if (diameter > 10){
            return true;
        }else {
            return false;
        }
    }

    private Drillbit getDrill(int diameter){
        if (diameter > 10){
            return new BigDrill();
        }else {
            return new SmallDrill();
        }
    }
}

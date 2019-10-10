package com.kroly.centre.ChainOfResponsibility;

/**
 * @ClassName PreparationList
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-10-10 10:54
 **/
public class PreparationList {

    private boolean washFace;

    private boolean washHair;

    private boolean haveBreakFast;

    public boolean isWashFace() {
        return washFace;
    }

    public void setWashFace(boolean washFace) {
        this.washFace = washFace;
    }

    public boolean isWashHair() {
        return washHair;
    }

    public void setWashHair(boolean washHair) {
        this.washHair = washHair;
    }

    public boolean isHaveBreakFast() {
        return haveBreakFast;
    }

    public void setHaveBreakFast(boolean haveBreakFast) {
        this.haveBreakFast = haveBreakFast;
    }
}

package rubbish.visitor;

/**
 * @ClassName CarCompant
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-19 10:59
 **/
public abstract class CarCompant {
    protected boolean broken;


    public abstract void acpect(Mechanic mechanic);

    public void setBroken(boolean broken){
        this.broken = broken;
    }

    public boolean getBroken(){
        return broken;
    }
}

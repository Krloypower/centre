package com.kroly.centre.visitor;

/**
 * @ClassName Car
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-19 11:08
 **/
public class Car extends CarCompant {
    private boolean broken = false;
    private CarCompant[] carCompants;

    public Car(){
        carCompants = new CarCompant[]{
                new Wheels(),new Engine(),new Brake()
        };
    }

    @Override
    public void acpect(Mechanic mechanic) {
        this.broken = false;
        if (mechanic.getName().equals("qualified")){
            int i = 0;
            while (i < carCompants.length ){
                CarCompant carCompant = carCompants[i];
                mechanic.visit(carCompant);
                this.broken = carCompant.getBroken();
                if (this.broken){
                    i++;
                }else {
                    return;
                }

            }
        }

    }

    @Override
    public boolean getBroken(){
        return this.broken;
    }
}

package rubbish.builder;

/**
 * @ClassName ColdDrink
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 10:36
 **/
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }


    @Override
    public abstract float price();
}

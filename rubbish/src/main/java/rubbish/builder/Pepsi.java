package rubbish.builder;

/**
 * @ClassName Pepsi
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 11:21
 **/
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}

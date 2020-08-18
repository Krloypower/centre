package rubbish.builder;

/**
 * @ClassName Coke
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-06-17 11:21
 **/
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}

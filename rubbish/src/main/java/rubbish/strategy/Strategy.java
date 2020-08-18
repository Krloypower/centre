package rubbish.strategy;

/**
 * @interface Strategy
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-16 16:18
 **/
public interface Strategy {
    void operation();

    StrategyEnum getStrategy();
}

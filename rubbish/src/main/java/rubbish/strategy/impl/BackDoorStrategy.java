package rubbish.strategy.impl;

import org.springframework.stereotype.Service;
import rubbish.strategy.Strategy;
import rubbish.strategy.StrategyEnum;

/**
 * @ClassName BackDoorStrategy
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-16 16:30
 **/
@Service("backDoorStrategy")
public class BackDoorStrategy implements Strategy {

    private final StrategyEnum current = StrategyEnum.BACKDOOR;

    @Override
    public void operation() {
        System.out.println("拜访乔国老，请求开后门");
    }

    @Override
    public StrategyEnum getStrategy() {
        return current;
    }
}

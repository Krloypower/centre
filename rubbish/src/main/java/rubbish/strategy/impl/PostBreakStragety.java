package rubbish.strategy.impl;

import org.springframework.stereotype.Service;
import rubbish.service.Log;
import rubbish.strategy.Strategy;
import rubbish.strategy.StrategyEnum;

/**
 * @ClassName PostBreakStragety
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-16 16:35
 **/
@Service("postBreakStragety")
public class PostBreakStragety implements Strategy {
    private final StrategyEnum current = StrategyEnum.PostBreak;
    @Override
    @Log
    public void operation() {
        System.out.println("拜访孙夫人，请求断后");
    }

    @Override
    public StrategyEnum getStrategy() {
        return current;
    }
}

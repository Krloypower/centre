package com.kroly.centre.strategy.impl;

import com.kroly.centre.annotation.service.Log;
import com.kroly.centre.strategy.Strategy;
import com.kroly.centre.strategy.StrategyEnum;
import org.springframework.stereotype.Service;

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

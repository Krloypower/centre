package com.kroly.centre.strategy.impl;

import com.kroly.centre.strategy.Strategy;
import com.kroly.centre.strategy.StrategyEnum;
import org.springframework.stereotype.Service;

/**
 * @ClassName GreenLightStragety
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-16 16:34
 **/
@Service("greenLightStragety")
public class GreenLightStragety implements Strategy {
    private final StrategyEnum current = StrategyEnum.GREENLIGHT;
    @Override
    public void operation() {
        System.out.println("拜访吴国太，请求开绿灯");
    }

    @Override
    public StrategyEnum getStrategy() {
        return current;
    }
}

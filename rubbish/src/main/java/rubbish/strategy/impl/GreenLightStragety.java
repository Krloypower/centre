package rubbish.strategy.impl;


import org.springframework.stereotype.Service;
import rubbish.service.Log;
import rubbish.strategy.Strategy;
import rubbish.strategy.StrategyEnum;

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
    @Log
    public void operation() {
        System.out.println("拜访吴国太，请求开绿灯");
    }

    @Override
    public StrategyEnum getStrategy() {
        return current;
    }
}

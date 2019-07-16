package com.kroly.centre.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName Context
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-16 16:36
 **/
@Component
public class Context implements ApplicationContextAware {

    private Map<String, Strategy> strategyMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        strategyMap = applicationContext.getBeansOfType(Strategy.class);
    }

    public Map<String, Strategy> getStrategyMap(){
        return strategyMap;
    }
}

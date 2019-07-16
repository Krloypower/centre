package com.kroly.centre;

import com.kroly.centre.strategy.Context;
import com.kroly.centre.strategy.Strategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CentreApplicationTests {

    @Autowired
    private Context context;

    @Test
    public void contextLoads() throws Exception {
        String test = "PostBreak";
        for (Strategy strategy : context.getStrategyMap().values()) {
            if (strategy.getStrategy().getType().equals(test)){
                strategy.operation();
                break;
            }
        }
    }

}

package com.centre.loop.service.Impl;

import com.centre.loop.service.Handler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName IoHandler
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/10
 * @Version 1.0
 **/
@Service("ioHandler")
@Slf4j
public class IoHandler implements Handler {

    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public void process() {
        taskExecutor.execute(()-> {
            log.info("xxxx");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

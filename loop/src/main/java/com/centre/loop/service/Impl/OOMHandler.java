package com.centre.loop.service.Impl;

import com.centre.loop.bean.BriefBean;
import com.centre.loop.service.Handler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IoHandler
 * @Description 模拟内存溢出 oom
 * @Author ouyangkang
 * @Date 2020/10/10
 * @Version 1.0
 **/
@Service("oomHandler")
@Slf4j
public class OOMHandler implements Handler {

    @Override
    public void process() {
        List<BriefBean> lists = new ArrayList<>();
        BriefBean.BriefBeanBuilder builder = BriefBean.builder();
        builder.id(1L).name("kang");
        lists.add(builder.build());
        for (long i = 0; i< lists.size(); i++){
            BriefBean.BriefBeanBuilder builder1 = BriefBean.builder();
            builder1.id(i).name("kang");
            lists.add(builder1.build());
        }
    }
}

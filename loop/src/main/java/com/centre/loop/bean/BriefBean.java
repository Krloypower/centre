package com.centre.loop.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName BriefBean
 * @Description 创意简报
 * @Author ouyangkang
 * @Date 2020/10/15
 * @Version 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BriefBean {

    private Long id;


    private String name;

    /**
     * 用户
     **/
    private String use;
}


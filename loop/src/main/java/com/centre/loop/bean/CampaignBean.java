package com.centre.loop.bean;

import com.centre.loop.enums.CampaignEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CampaignBean
 * @Description 竞争，比稿
 * @Author ouyangkang
 * @Date 2020/10/15
 * @Version 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampaignBean {

    private Long id;

    /**
     * 竞争类型
     **/
    private CampaignEnum type;

    /**
     * 比稿成本
     **/
    private Long price;
}

package com.centre.loop.enums;

public enum CampaignEnum {
    PUBLIC(0, "公共的"),
    PRIVATE(2, "私有的");
    private Integer key;

    private String vaule;

    CampaignEnum(Integer key, String vaule) {
        this.key = key;
        this.vaule = vaule;
    }

    public Integer getKey() {
        return key;
    }

    public String getVaule() {
        return vaule;
    }
}

package com.neo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Site {

    private Long SITE_ID;        //站点ID
    private String SITE_ADDRESS;

    @JsonProperty(value = "SITE_ID")
    public Long getSITE_ID() {
        return SITE_ID;
    }
    public void setSITE_ID(Long SITE_ID) {
        this.SITE_ID = SITE_ID;
    }

    @JsonProperty(value = "SITE_ADDRESS")
    public String getSITE_ADDRESS() {
        return SITE_ADDRESS;
    }
    public void setSITE_ADDRESS(String SITE_ADDRESS) {
        this.SITE_ADDRESS = SITE_ADDRESS;
    }

}

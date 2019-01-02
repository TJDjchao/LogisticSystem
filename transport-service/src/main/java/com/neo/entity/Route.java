package com.neo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;


public class Route {
    private Long SITE_1_ID;        //站点ID
    private Long SITE_2_ID;
    private Long DISTANCE;

    @JsonProperty(value = "SITE_1_ID")
    public Long getSITE_1_ID() {
        return SITE_1_ID;
    }
    public void setSITE_1_ID(Long SITE_1_ID) {
        this.SITE_1_ID = SITE_1_ID;
    }

    @JsonProperty(value = "SITE_2_ID")
    public Long getSITE_2_ID() {
        return SITE_2_ID;
    }
    public void setSITE_2_ID(Long SITE_2_ID) {
        this.SITE_2_ID = SITE_2_ID;
    }

    @JsonProperty(value = "DISTANCE")
    public Long getDISTANCE() {
        return DISTANCE;
    }
    public void setDISTANCE(Long DISTANCE) {
        this.DISTANCE = DISTANCE;
    }

}

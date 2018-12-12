package com.neo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
    private Long ACCOUNT_ID;
    private Long PASSWORD;

    @JsonProperty(value = "ACCOUNT_ID")
    public Long getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    public void setACCOUNT_ID(Long ACCOUNT_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
    }

    @JsonProperty(value = "PASSWORD")
    public Long getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(Long PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}

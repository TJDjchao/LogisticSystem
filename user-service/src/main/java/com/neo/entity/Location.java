package com.neo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Location {
    private Long ACCOUNT_ID;
    private String NAME;
    private Long PHONE;
    private String ADDRESS;
    private String NEWADDRESS;

    @JsonProperty(value = "ACCOUNT_ID")
    public Long getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    public void setACCOUNT_ID(Long ACCOUNT_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
    }


    @JsonProperty(value = "NAME")
    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @JsonProperty(value = "PHONE")
    public Long getPHONE() {
        return PHONE;
    }

    public void setPHONE(Long PHONE) {
        this.PHONE = PHONE;
    }

    @JsonProperty(value = "ADDRESS")
    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    @JsonProperty(value = "NEWADDRESS")
    public String getNEWADDRESS() {
        return NEWADDRESS;
    }

    public void setNEWADDRESS(String NEWADDRESS) {
        this.NEWADDRESS = NEWADDRESS;
    }




}
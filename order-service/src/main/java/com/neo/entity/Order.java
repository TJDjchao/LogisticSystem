package com.neo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Order {

    private Long ACCOUNT_ID;        //发送订单者ID
    private Long BILL_ID;
    private String SENDER_NAME;
    private Long SENDER_PHONE;
    private String SENDER_ADDRESS;
    private String RECEIVER_NAME;
    private Long RECEIVER_PHONE;
    private String RECEIVER_ADDRESS;
    private String TYPE;
    private Date APPOINTMENT;       //预约上门时间，可选参数
    private Long FEE;
    private Long WEIGHT;

    private Long SITE_ID;
    private Date TIME;
    private Integer STATE;          //订单状态（四种 0 未揽件 1 已揽件 2 运输中 3 派送中 4 已签收 ）

    @JsonProperty(value = "ACCOUNT_ID")
    public Long getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    public void setACCOUNT_ID(Long ACCOUNT_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
    }

    @JsonProperty(value = "BILL_ID")
    public Long getBILL_ID() {
        return BILL_ID;
    }

    public void setBILL_ID(Long BILL_ID) {
        this.BILL_ID = BILL_ID;
    }

    @JsonProperty(value = "SITE_ID")
    public Long getSITE_ID() {
        return SITE_ID;
    }

    public void setSITE_ID(Long SITE_ID) {
        this.SITE_ID = SITE_ID;
    }

    @JsonProperty(value = "TIME")
    public Date getTIME() {
        return TIME;
    }

    public void setTIME(Date TIME) {
        this.TIME = TIME;
    }

    @JsonProperty(value = "STATE")
    public Integer getSTATE() {
        return STATE;
    }

    public void setSTATE(Integer STATE) {
        this.STATE = STATE;
    }

    @JsonProperty(value = "SENDER_NAME")
    public String getSENDER_NAME() {
        return SENDER_NAME;
    }

    public void setSENDER_NAME(String SENDER_NAME) {
        this.SENDER_NAME = SENDER_NAME;
    }

    @JsonProperty(value = "SENDER_PHONE")
    public Long getSENDER_PHONE() {
        return SENDER_PHONE;
    }

    public void setSENDER_PHONE(Long SENDER_PHONE) {
        this.SENDER_PHONE = SENDER_PHONE;
    }

    @JsonProperty(value = "SENDER_ADDRESS")
    public String getSENDER_ADDRESS() {
        return SENDER_ADDRESS;
    }

    public void setSENDER_ADDRESS(String SENDER_ADDRESS) {
        this.SENDER_ADDRESS = SENDER_ADDRESS;
    }

    @JsonProperty(value = "RECEIVER_NAME")
    public String getRECEIVER_NAME() {
        return RECEIVER_NAME;
    }

    public void setRECEIVER_NAME(String RECEIVER_NAME) {
        this.RECEIVER_NAME = RECEIVER_NAME;
    }

    @JsonProperty(value = "RECEIVER_PHONE")
    public Long getRECEIVER_PHONE() {
        return RECEIVER_PHONE;
    }

    public void setRECEIVER_PHONE(Long RECEIVER_PHONE) {
        this.RECEIVER_PHONE = RECEIVER_PHONE;
    }

    @JsonProperty(value = "RECEIVER_ADDRESS")
    public String getRECEIVER_ADDRESS() {
        return RECEIVER_ADDRESS;
    }

    public void setRECEIVER_ADDRESS(String RECEIVER_ADDRESS) {
        this.RECEIVER_ADDRESS = RECEIVER_ADDRESS;
    }

    @JsonProperty(value = "TYPE")
    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    @JsonProperty(value = "APPOINTMENT")
    public Date getAPPOINTMENT() {
        return APPOINTMENT;
    }

    public void setAPPOINTMENT(Date APPOINTMENT) {
        this.APPOINTMENT = APPOINTMENT;
    }

    @JsonProperty(value = "FEE")
    public Long getFEE() {
        return FEE;
    }

    public void setFEE(Long FEE) {
        this.FEE = FEE;
    }

    @JsonProperty(value = "WEIGHT")
    public Long getWEIGHT() {
        return WEIGHT;
    }

    public void setWEIGHT(Long WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

}

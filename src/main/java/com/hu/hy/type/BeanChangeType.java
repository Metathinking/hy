package com.hu.hy.type;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) BeanChangeType.java 2017/03/16 16:00
 */
public enum  BeanChangeType {
    REGISTER("注册"),
    EXTEND("推广"),
    SIGN_IN("签到"),
    RECHARGE("充值"),
    DONG_JIE("冻结"),
    JIE_DONG("解冻"),
    CONSUME("消费");

    private String description;

    private BeanChangeType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
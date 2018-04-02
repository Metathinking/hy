package com.hu.hy.domain;

/**
 * 充值记录
 * @author 胡玉波
 * @version 1.0
 * @(#) RechargeRecord.java 2017/03/17 09:22
 */
public class RechargeRecord {

    private int id;
    private String userId;
    private int money;
    private int bean;
    private long time;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBean() {
        return bean;
    }

    public void setBean(int bean) {
        this.bean = bean;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
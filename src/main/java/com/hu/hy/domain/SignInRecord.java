package com.hu.hy.domain;

/**
 * 签到记录
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SignInRecord.java 2017/03/15 21:43
 */
public class SignInRecord {

    private int id;
    private String userId;
    private int beanCount;//领取推广豆的数量
    private long time;

    public int getBeanCount() {
        return beanCount;
    }

    public void setBeanCount(int beanCount) {
        this.beanCount = beanCount;
    }

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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
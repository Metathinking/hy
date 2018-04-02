package com.hu.hy.domain;

/**
 * 查看记录
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SeeRecord.java 2017/03/15 21:12
 */
public class SeeRecord {

    private int id;
    private String userId;
    private String beikanId;
    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
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

    public String getBeikanId() {
        return beikanId;
    }

    public void setBeikanId(String beikanId) {
        this.beikanId = beikanId;
    }
}
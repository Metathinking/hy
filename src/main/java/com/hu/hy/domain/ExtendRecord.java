package com.hu.hy.domain;

/**
 * 推广记录
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ExtendRecord.java 2017/03/15 21:38
 */
public class ExtendRecord {

    private int id;
    private String userId;//推广人id
    private String extendId;//被推广者
    private long time;

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

    public String getExtendId() {
        return extendId;
    }

    public void setExtendId(String extendId) {
        this.extendId = extendId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
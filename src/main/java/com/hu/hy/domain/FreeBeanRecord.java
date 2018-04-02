package com.hu.hy.domain;

/**
 * 免豆查看记录
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) FreeBeanRecord.java 2017/03/20 00:38
 */
public class FreeBeanRecord {

    private int id;
    private String userId;//设置人的id
    private String seeId;//查看人的id
    private String seeName;//查看人的昵称
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

    public String getSeeId() {
        return seeId;
    }

    public void setSeeId(String seeId) {
        this.seeId = seeId;
    }

    public String getSeeName() {
        return seeName;
    }

    public void setSeeName(String seeName) {
        this.seeName = seeName;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
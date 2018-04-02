package com.hu.hy.domain;

/**
 * 免豆查看设置
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) FreeBeanSetting.java 2017/03/19 23:10
 */
public class FreeBeanSetting {

    private String id;//同 userID
    private int startCount;//开始时的上限
    private int count;//剩余推广豆
    private boolean open;//开启
    private long time;//开启时间

    public int getStartCount() {
        return startCount;
    }

    public void setStartCount(int startCount) {
        this.startCount = startCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
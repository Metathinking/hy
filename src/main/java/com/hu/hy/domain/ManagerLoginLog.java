package com.hu.hy.domain;

/**
 * 管理员登录日志
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ManagerLoginLog.java 2016/07/04 22:03
 */
public class ManagerLoginLog {

    private int id;
    private int managerId;
    private String managerName;
    private String ip;
    private long time;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
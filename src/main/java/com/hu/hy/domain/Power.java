package com.hu.hy.domain;

/**
 *权限
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) Power.java 2017/03/24 15:41
 */
public class Power {

    private int id;
    private int managerId;
    /**
     * @see com.hu.hy.type.PowerType
     */
    private String power;
    private String description;
    private boolean open;

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

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

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
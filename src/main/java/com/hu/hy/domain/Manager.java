package com.hu.hy.domain;

/**
 * 管理员
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) Manager.java 2016/07/04 22:01
 */
public class Manager {

    private int id;
    private String name;
    private String password;
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
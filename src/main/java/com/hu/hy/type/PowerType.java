package com.hu.hy.type;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) PowerType.java 2017/03/24 15:43
 */
public enum  PowerType {
    SITE_HOME("首页"),
    USER_MANAGER("用户管理"),
    SITE_SETTING("网站设置"),
    POWER_MANAGER("权限管理"),
    LOGIN_LOG("登录日志");

    private String description;

    private PowerType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
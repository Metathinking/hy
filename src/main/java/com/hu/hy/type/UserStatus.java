package com.hu.hy.type;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UserStatus.java 2017/03/16 15:05
 */
public enum UserStatus {
    INIT("未申请审核"),
    WAIT("待审核"),
    NO_PASS("审核未通过"),
    SHOW("显示"),
    HIDE("隐身"),
    CANCEL("屏蔽");

    private String description;

    private UserStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static String getDescription(String name){
        UserStatus status = UserStatus.valueOf(name);
        return status.getDescription();
    }
}
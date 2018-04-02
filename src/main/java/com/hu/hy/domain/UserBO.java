package com.hu.hy.domain;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UserBO.java 2017/03/16 16:44
 */
public class UserBO {

//    private BaiduUser user;
    private User user;
    private boolean hasSignIn;
    private UserInfo userInfo;
    private FreeBeanSetting freeBeanSetting;

    public boolean isHasSignIn() {
        return hasSignIn;
    }

    public void setHasSignIn(boolean hasSignIn) {
        this.hasSignIn = hasSignIn;
    }

    public FreeBeanSetting getFreeBeanSetting() {
        return freeBeanSetting;
    }

    public void setFreeBeanSetting(FreeBeanSetting freeBeanSetting) {
        this.freeBeanSetting = freeBeanSetting;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
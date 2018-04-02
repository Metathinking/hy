package com.hu.hy.domain;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SiteSetting.java 2017/03/16 15:00
 */
public class SiteSetting {

    private int id;
    private int registerDou;//注册即首次登录送豆数量设置
    private int signInStart;//签到第一天，赠送豆数量
    private int signInStep;//连续签到，每天增加数量
    private int signInEnd;//签到赠送豆数量上限
    private int scale;//scale=10 即 1元=10推广豆

    private long time;//更新时间

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

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

    public int getRegisterDou() {
        return registerDou;
    }

    public void setRegisterDou(int registerDou) {
        this.registerDou = registerDou;
    }

    public int getSignInStart() {
        return signInStart;
    }

    public void setSignInStart(int signInStart) {
        this.signInStart = signInStart;
    }

    public int getSignInStep() {
        return signInStep;
    }

    public void setSignInStep(int signInStep) {
        this.signInStep = signInStep;
    }

    public int getSignInEnd() {
        return signInEnd;
    }

    public void setSignInEnd(int signInEnd) {
        this.signInEnd = signInEnd;
    }
}
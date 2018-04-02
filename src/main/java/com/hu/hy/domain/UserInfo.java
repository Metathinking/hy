package com.hu.hy.domain;

/**
 * 用户的互推豆和积分情况
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UserInfo.java 2017/03/15 21:03
 */
public class UserInfo {

    private String id;//与用户id 相同
    private int bean;//互推豆数量 可增可减，不可小于0
    private int jifen;//积分 影响搜索排名  只增不减,不可小于0
    private int extendCount;//推广数量

    public int getExtendCount() {
        return extendCount;
    }

    public void setExtendCount(int extendCount) {
        if(extendCount<this.extendCount){
            throw new IllegalArgumentException("推广数量不应该减少");
        }
        this.extendCount = extendCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBean() {
        return bean;
    }

    public void setBean(int bean) {
        if(bean<0){
            throw new IllegalArgumentException("推广豆数量不能小于0");
        }
        this.bean = bean;
    }

    public int getJifen() {
        return jifen;
    }

    public void setJifen(int jifen) {
        if(jifen<this.jifen){
            throw new IllegalArgumentException("积分不能减少");
        }
        this.jifen = jifen;
    }
}
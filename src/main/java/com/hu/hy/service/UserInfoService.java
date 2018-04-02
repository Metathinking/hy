package com.hu.hy.service;

import com.hu.hy.domain.UserInfo;
import com.hu.hy.type.BeanChangeType;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UserInfoService.java 2017/03/16 15:35
 */
public interface UserInfoService {

    List<UserInfo> list(Map<String,Object> parameters);

    UserInfo findById(String id);

    int getCount(Map<String,Object> parameters);

    void addBean(String openId, int beanCount, BeanChangeType signIn,boolean jifenChange);

    void subBean(String userId, int beanCount, BeanChangeType signIn);
}
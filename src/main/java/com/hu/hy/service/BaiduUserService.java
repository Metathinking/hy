package com.hu.hy.service;

import com.hu.hy.domain.BaiduUser;
import com.hu.hy.domain.UserBO;
import com.hu.hy.type.UserStatus;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) BaiduUserService.java 2017/03/15 10:56
 */
public interface BaiduUserService {

    BaiduUser edit(BaiduUser user, String ip);

    UserBO findUserBOById(int id);

    void delete(String id);

    List<BaiduUser> list(Map<String,Object> parameter);

    BaiduUser findById(int id);

    BaiduUser findByBaiduId(String uid);

    int getCount(Map<String,Object> parameter);

    void updateStatus(int id,UserStatus status);


    BaiduUser toSee(BaiduUser user, int id);
}
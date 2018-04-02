package com.hu.hy.service;


import com.hu.hy.domain.User;
import com.hu.hy.domain.UserBO;
import com.hu.hy.type.UserStatus;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UserService.java 2017/03/11 23:27
 */
public interface UserService {

    User edit(User user, String ip);

    UserBO findUserBOById(String id);

//    void delete(String id);

    List<User> list(Map<String,Object> parameter);


    User findByOpenId(String uid);

    int getCount(Map<String,Object> parameter);

    void updateStatus(String id,UserStatus status);


    User toSee(User user, String id);

    User editMsg(User user);
}

package com.hu.hy.repository;

import com.hu.hy.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UserInfoRepository.java 2017/03/16 15:33
 */
@Repository
public interface UserInfoRepository {

    void create(UserInfo userInfo);

    void update(UserInfo userInfo);

    List<UserInfo> list(Map<String,Object> parameters);

    UserInfo findById(String id);

    int getCount(Map<String,Object> parameters);

}
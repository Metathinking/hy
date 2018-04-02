package com.hu.hy.repository;

import com.hu.hy.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UserRepository.java 2017/03/11 23:23
 */
@Repository
public interface UserRepository {

    void create(User user);

    void update(User user);

//    void delete(String id);

    List<User> list(Map<String,Object> parameter);

    User findByOpenId(String uid);

    int getCount(Map<String,Object> parameter);


    void updateStatus(@Param("id")String id, @Param("status") String status);
}
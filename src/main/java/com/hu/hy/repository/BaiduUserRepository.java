package com.hu.hy.repository;

import com.hu.hy.domain.BaiduUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) BaiduUserRepository.java 2017/03/15 10:55
 */
@Repository
public interface BaiduUserRepository {

    void create(BaiduUser user);

    void update(BaiduUser user);

    void delete(String id);

    List<BaiduUser> list(Map<String,Object> parameter);

    BaiduUser findById(int id);

    BaiduUser findByBaiduId(String uid);

    int getCount(Map<String,Object> parameter);

    int getMaxId();

    void updateStatus(@Param("id")int id,@Param("status") String status);
}
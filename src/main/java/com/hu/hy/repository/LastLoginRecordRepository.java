package com.hu.hy.repository;

import com.hu.hy.domain.LastLoginRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) LastLoginRecordRepository.java 2017/03/15 22:04
 */
@Repository
public interface LastLoginRecordRepository {

    void create(LastLoginRecord lastLoginRecord);

    void update(LastLoginRecord lastLoginRecord);

    List<LastLoginRecord> list(Map<String,Object> parameters);

    int getCount(Map<String,Object> parameters);

    LastLoginRecord findById(String id);
}
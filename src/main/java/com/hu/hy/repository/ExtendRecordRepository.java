package com.hu.hy.repository;

import com.hu.hy.domain.ExtendRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ExtendRecordRepository.java 2017/03/15 22:01
 */
@Repository
public interface ExtendRecordRepository {

    void create(ExtendRecord extendRecord);

    List<ExtendRecord> list(Map<String,Object> parameters);

    int getCount(Map<String,Object> parameters);

    int getMaxId();

    ExtendRecord findById(int id);
}
package com.hu.hy.repository;

import com.hu.hy.domain.JifenRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) JifenRecordRepository.java 2017/03/15 22:03
 */
@Repository
public interface JifenRecordRepository {

    void create(JifenRecord jifenRecord);

    List<JifenRecord> list(Map<String,Object> parameters);

    int getCount(Map<String,Object> parameters);

    int getMaxId();
}
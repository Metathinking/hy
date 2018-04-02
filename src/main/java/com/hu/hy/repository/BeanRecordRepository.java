package com.hu.hy.repository;

import com.hu.hy.domain.BeanRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) BeanRecord.java 2017/03/15 21:57
 */
@Repository
public interface BeanRecordRepository {

    void create(BeanRecord beanRecord);

    List<BeanRecord> list(Map<String,Object> parameters);

    int getCount(Map<String,Object> parameters);

    int getMaxId();
}
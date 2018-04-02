package com.hu.hy.repository;

import com.hu.hy.domain.FreeBeanRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) FreeBeanRecordRepository.java 2017/03/20 00:44
 */
@Repository
public interface FreeBeanRecordRepository {

    void create(FreeBeanRecord freeBeanRecord);

    FreeBeanRecord findById(int id);

    List<FreeBeanRecord> list(Map<String,Object> parameters);

    int getCount(Map<String,Object> parameters);

    int getMaxId();
}
package com.hu.hy.repository;

import com.hu.hy.domain.RechargeRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) RechargeRecordRepository.java 2017/03/17 09:26
 */
@Repository
public interface RechargeRecordRepository {

    void create(RechargeRecord rechargeRecord);

    List<RechargeRecord> list(Map<String,Object> parameters);

    int getCount(Map<String,Object> parameters);

    int getMaxId();
}
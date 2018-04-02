package com.hu.hy.service;

import com.hu.hy.domain.RechargeRecord;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) RechargeRecordService.java 2017/03/17 09:27
 */
public interface RechargeRecordService {

    RechargeRecord create(RechargeRecord rechargeRecord);

    List<RechargeRecord> list(Map<String, Object> parameters);

    int getCount(Map<String, Object> parameters);
}
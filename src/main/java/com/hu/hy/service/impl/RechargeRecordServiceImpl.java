package com.hu.hy.service.impl;

import com.hu.hy.cache.SiteCache;
import com.hu.hy.domain.RechargeRecord;
import com.hu.hy.domain.UserInfo;
import com.hu.hy.repository.RechargeRecordRepository;
import com.hu.hy.service.RechargeRecordService;
import com.hu.hy.service.UserInfoService;
import com.hu.hy.type.BeanChangeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) RechargeRecordServiceImpl.java 2017/03/17 09:29
 */
@Service
public class RechargeRecordServiceImpl implements RechargeRecordService {

    @Autowired
    private RechargeRecordRepository rechargeRecordRepository;

    @Autowired
    private UserInfoService userInfoService;

    public RechargeRecord create(RechargeRecord rechargeRecord) {
        int maxId = rechargeRecordRepository.getMaxId();
        maxId++;
        rechargeRecord.setId(maxId);
        rechargeRecord.setTime(System.currentTimeMillis());
        int scale = SiteCache.getSiteSetting().getScale();
        rechargeRecord.setBean(rechargeRecord.getMoney() * scale);
        rechargeRecordRepository.create(rechargeRecord);
        userInfoService.addBean(rechargeRecord.getUserId(),rechargeRecord.getBean(), BeanChangeType.RECHARGE,true);
        return rechargeRecord;
    }

    public List<RechargeRecord> list(Map<String, Object> parameters) {
        return rechargeRecordRepository.list(parameters);
    }

    public int getCount(Map<String, Object> parameters) {
        return rechargeRecordRepository.getCount(parameters);
    }
}
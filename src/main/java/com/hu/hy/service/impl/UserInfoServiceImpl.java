package com.hu.hy.service.impl;

import com.hu.hy.domain.BeanRecord;
import com.hu.hy.domain.JifenRecord;
import com.hu.hy.domain.UserInfo;
import com.hu.hy.exception.ServiceException;
import com.hu.hy.repository.BeanRecordRepository;
import com.hu.hy.repository.JifenRecordRepository;
import com.hu.hy.repository.UserInfoRepository;
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
 * @(#) UserInfoServiceImpl.java 2017/03/16 15:36
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private BeanRecordRepository beanRecordRepository;

    @Autowired
    private JifenRecordRepository jifenRecordRepository;

    /**
     * 创建推广豆变更记录
     *
     * @param userInfo
     * @param time
     */
    public void creatBeanRecord(UserInfo userInfo, int before, long time, BeanChangeType type) {
        BeanRecord beanRecord = new BeanRecord();
        int beanMaxId = beanRecordRepository.getMaxId();
        beanMaxId++;
        beanRecord.setId(beanMaxId);
        beanRecord.setBefore(before);
        beanRecord.setCount(userInfo.getBean() - before);
        beanRecord.setAfter(userInfo.getBean());
        beanRecord.setUserId(userInfo.getId());
        beanRecord.setTime(time);
        beanRecord.setCategory(type.getDescription());
        beanRecordRepository.create(beanRecord);
    }

    /**
     * 创建积分变更记录
     *
     * @param userInfo
     * @param time
     */
    public void creatJifenRecord(UserInfo userInfo, int before, long time, BeanChangeType type) {
        JifenRecord jifenRecord = new JifenRecord();
        int jifenMaxId = jifenRecordRepository.getMaxId();
        jifenMaxId++;
        jifenRecord.setId(jifenMaxId);
        jifenRecord.setUserId(userInfo.getId());
        jifenRecord.setBefore(before);
        jifenRecord.setCount(userInfo.getJifen() - before);
        jifenRecord.setAfter(userInfo.getJifen());
        jifenRecord.setTime(time);
        jifenRecord.setCategory(type.getDescription());
        jifenRecordRepository.create(jifenRecord);
    }

    public List<UserInfo> list(Map<String, Object> parameters) {
        return userInfoRepository.list(parameters);
    }

    public UserInfo findById(String id) {
        return userInfoRepository.findById(id);
    }

    public int getCount(Map<String, Object> parameters) {
        return userInfoRepository.getCount(parameters);
    }

    /**
     *
     * @param userId
     * @param beanCount
     * @param type
     * @param jifenChange 积分是否一起变动,解冻推广豆时，积分不变
     */
    public void addBean(String userId, int beanCount, BeanChangeType type,boolean jifenChange) {
        UserInfo db = userInfoRepository.findById(userId);
        int beforeBean = 0;//变更前的数量
        int beforeJifen = 0;//变更前的数量
        if (db == null) {
            db = new UserInfo();
            db.setId(userId);
            db.setBean(beanCount);
            db.setJifen(beanCount);
            db.setExtendCount(0);
            userInfoRepository.create(db);
        } else {
            beforeBean = db.getBean();
            beforeJifen = db.getJifen();
            db.setBean(beforeBean + beanCount);
            if(jifenChange){
                db.setJifen(beforeJifen + beanCount);
            }
            db.setExtendCount(db.getExtendCount());
            userInfoRepository.update(db);
        }
        long time = System.currentTimeMillis();
        creatBeanRecord(db, beforeBean, time, type);
        if(jifenChange){
            creatJifenRecord(db, beforeJifen, time, type);
        }
    }

    /**
     * 扣除推广豆
     * @param userId
     * @param beanCount
     * @param type
     */
    public void subBean(String userId, int beanCount, BeanChangeType type) {
        UserInfo db = userInfoRepository.findById(userId);
        if (db.getBean() <beanCount) {
            throw new ServiceException(201, "您的推广豆储备不足，无法继续");
        }
        int beforeBean = db.getBean();
        db.setBean(beforeBean - beanCount);
        db.setExtendCount(db.getExtendCount());
        userInfoRepository.update(db);
        long time = System.currentTimeMillis();
        creatBeanRecord(db, beforeBean, time, type);
    }


}
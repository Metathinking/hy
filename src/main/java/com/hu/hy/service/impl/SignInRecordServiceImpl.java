package com.hu.hy.service.impl;

import com.hu.hy.cache.SiteCache;
import com.hu.hy.domain.SignInRecord;
import com.hu.hy.domain.SiteSetting;
import com.hu.hy.exception.ServiceException;
import com.hu.hy.repository.SignInRecordRepository;
import com.hu.hy.service.SignInRecordService;
import com.hu.hy.service.UserInfoService;
import com.hu.hy.type.BeanChangeType;
import com.hu.hy.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SignInRecordServiceImpl.java 2017/03/16 21:46
 */
@Service
public class SignInRecordServiceImpl implements SignInRecordService {

    @Autowired
    private SignInRecordRepository signInRecordRepository;

    @Autowired
    private UserInfoService userInfoService;

    public void create(String userId) {
        SignInRecord db = signInRecordRepository.findLastByUserId(userId);
        SiteSetting siteSetting = SiteCache.getSiteSetting();
        if (db == null) {
            //首次签到
            db = new SignInRecord();
            int maxId = signInRecordRepository.getMaxId();
            maxId++;
            db.setId(maxId);
            db.setUserId(userId);
            db.setBeanCount(siteSetting.getSignInStart());
            db.setTime(System.currentTimeMillis());
            signInRecordRepository.create(db);
            userInfoService.addBean(userId, db.getBeanCount(), BeanChangeType.SIGN_IN,true);
        } else {
            //已经签过到
            if(DateUtil.isInToday(db.getTime())){
                throw new ServiceException(201,"您今天已经签过到了");
            }
            boolean isYestoday = DateUtil.isYestoday(db.getTime());
            int addBeanCount=0;
            if (isYestoday) {
                int before = db.getBeanCount();
                if(before>=siteSetting.getSignInEnd()){//达到上限，不再增加
                    addBeanCount=before;
                }else{//未达到上限，继续增加
                    addBeanCount=before+siteSetting.getSignInStep();
                }
            } else {
                addBeanCount=siteSetting.getSignInStart();
            }
            SignInRecord signInRecord = new SignInRecord();
            int maxId = signInRecordRepository.getMaxId();
            maxId++;
            signInRecord.setId(maxId);
            signInRecord.setUserId(userId);
            signInRecord.setTime(System.currentTimeMillis());
            signInRecord.setBeanCount(addBeanCount);
            signInRecordRepository.create(signInRecord);
            userInfoService.addBean(userId,addBeanCount,BeanChangeType.SIGN_IN,true);
        }
    }

    public boolean hasSignIn(String userId) {
        SignInRecord db = signInRecordRepository.findLastByUserId(userId);
        if(db==null){
            return false;
        }
        if(DateUtil.isInToday(db.getTime())){
            return true;
        }
        return false;
    }

    public List<SignInRecord> list(Map<String, Object> parameters) {
        return signInRecordRepository.list(parameters);
    }

    public int getCount(Map<String, String> parameters) {
        return signInRecordRepository.getCount(parameters);
    }

    public SignInRecord findById(int id) {
        return signInRecordRepository.findById(id);
    }
}
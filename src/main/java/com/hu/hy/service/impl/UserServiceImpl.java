package com.hu.hy.service.impl;

import com.hu.hy.cache.SiteCache;
import com.hu.hy.domain.*;
import com.hu.hy.repository.*;
import com.hu.hy.service.SignInRecordService;
import com.hu.hy.service.UserInfoService;
import com.hu.hy.service.UserService;
import com.hu.hy.type.BeanChangeType;
import com.hu.hy.type.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UserServiceImpl.java 2017/03/11 23:29
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LastLoginRecordRepository lastLoginRecordRepository;

    @Autowired
    private SeeRecordRepository seeRecordRepository;

    @Autowired
    private FreeBeanSettingRepository freeBeanSettingRepository;

    @Autowired
    private FreeBeanRecordRepository freeBeanRecordRepository;

    @Autowired
    private SignInRecordService signInRecordService;

    public User edit(User user, String ip) {
        User db = findByOpenId(user.getOpenid());
        if (db == null) {
            user.setStatus(UserStatus.WAIT.name());
            user.setRegisterTime(System.currentTimeMillis());
            user.setStatus(UserStatus.INIT.name());
            userRepository.create(user);
            userInfoService.addBean(user.getOpenid(), SiteCache.getSiteSetting().getRegisterDou(), BeanChangeType.REGISTER,true);
            createLastLoginRecord(user, ip);
            createFreeBeanSetting(user.getOpenid());
            return user;
        } else {
            db.setNickname(user.getNickname());
            db.setHeadimgurl(user.getHeadimgurl());
            userRepository.update(db);
            updateLastLoginRecord(db, ip);
            return db;
        }
    }

    private void createFreeBeanSetting(String openId) {
        FreeBeanSetting setting = new FreeBeanSetting();
        setting.setId(openId);
        setting.setStartCount(0);
        setting.setCount(0);
        setting.setOpen(false);
        setting.setTime(System.currentTimeMillis());
    }

    public UserBO findUserBOById(String id) {
        UserBO userBO = new UserBO();
        User user = userRepository.findByOpenId(id);
        UserInfo userInfo = userInfoService.findById(id);
        FreeBeanSetting freeBeanSetting = freeBeanSettingRepository.findById(id);
        userBO.setUser(user);
        userBO.setUserInfo(userInfo);
        userBO.setFreeBeanSetting(freeBeanSetting);
        userBO.setHasSignIn(signInRecordService.hasSignIn(id));
        return userBO;
    }

    private void createLastLoginRecord(User user, String ip) {
        LastLoginRecord lastLoginRecord = new LastLoginRecord();
        lastLoginRecord.setId(user.getOpenid());
        lastLoginRecord.setTime(System.currentTimeMillis());
        lastLoginRecord.setIp(ip);
        lastLoginRecordRepository.create(lastLoginRecord);
    }

    private void updateLastLoginRecord(User user, String ip) {
        LastLoginRecord db = lastLoginRecordRepository.findById(user.getOpenid());
        db.setTime(System.currentTimeMillis());
        db.setIp(ip);
        lastLoginRecordRepository.update(db);
    }

    /**
     * @param user 登录的人
     * @param id   被查看信息人的id
     * @return 被查看的人的信息
     */
    public User toSee(User user, String id) {
        SeeRecord seeRecord = seeRecordRepository.findByUserId(user.getOpenid(), id);
        if (seeRecord==null){//之前没有查看过
            FreeBeanSetting beikanSetting = freeBeanSettingRepository.findById(id);
            if(beikanSetting!=null
                    &&beikanSetting.isOpen()
                    &&beikanSetting.getCount()>0){//被看人开启了免豆设置，扣除被看人设置中的推广豆
                beikanSetting.setCount(beikanSetting.getCount()-1);
                if(beikanSetting.getCount()==0){
                    beikanSetting.setOpen(false);
                }
                freeBeanSettingRepository.update(beikanSetting);
                FreeBeanRecord beanRecord = new FreeBeanRecord();
                int maxId = freeBeanRecordRepository.getMaxId();
                maxId++;
                beanRecord.setId(maxId);
                beanRecord.setUserId(id);
                beanRecord.setSeeId(user.getOpenid());
                beanRecord.setSeeName(user.getNickname());
                beanRecord.setTime(System.currentTimeMillis());
                freeBeanRecordRepository.create(beanRecord);
            }else{//扣除查看人的推广豆
                userInfoService.subBean(user.getOpenid(), 1, BeanChangeType.CONSUME);
            }
            createSeeRecord(user.getOpenid(), id);
        }
        User beenSeeUser = userRepository.findByOpenId(id);
        return beenSeeUser;
    }

    /**
     * @param seeId    查看的人
     * @param beiKanId 被查看的人
     */
    private void createSeeRecord(String seeId, String beiKanId) {
        SeeRecord seeRecord = new SeeRecord();
        int maxId = seeRecordRepository.getMaxId();
        maxId++;
        seeRecord.setId(maxId);
        seeRecord.setUserId(seeId);
        seeRecord.setBeikanId(beiKanId);
        seeRecord.setTime(System.currentTimeMillis());
        seeRecordRepository.create(seeRecord);
    }

    public void updateStatus(String id, UserStatus status) {
        userRepository.updateStatus(id, status.name());
    }

//    public void delete(String id) {
//        userRepository.delete(id);
//    }

    public List<User> list(Map<String, Object> parameter) {
        return userRepository.list(parameter);
    }


    public User findByOpenId(String uid) {
        return userRepository.findByOpenId(uid);
    }

    public int getCount(Map<String, Object> parameter) {
        return userRepository.getCount(parameter);
    }

    /**
     * 编辑用户的微信号、二维码、标签、介绍
     * 其中微信号只能保存一次
     * @param user
     * @return
     */
    public User editMsg(User user) {
        User db = userRepository.findByOpenId(user.getOpenid());
        if(StringUtils.isEmpty(db.getWeixinNo())){
            db.setWeixinNo(user.getWeixinNo());
        }
        db.setCodeUrl(user.getCodeUrl());
        db.setIntroduction(user.getIntroduction());
        db.setLabel(user.getLabel());
        userRepository.update(db);
        return db;
    }
}
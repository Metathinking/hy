package com.hu.hy.service.impl;

import com.hu.hy.cache.SiteCache;
import com.hu.hy.domain.*;
import com.hu.hy.exception.ServiceException;
import com.hu.hy.repository.*;
import com.hu.hy.service.BaiduUserService;
import com.hu.hy.service.SignInRecordService;
import com.hu.hy.service.UserInfoService;
import com.hu.hy.type.BeanChangeType;
import com.hu.hy.type.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) BaiduUserServiceImpl.java 2017/03/15 10:57
 */
@Service
public class BaiduUserServiceImpl  {

//    @Autowired
//    private BaiduUserRepository baiduUserRepository;
//
//    @Autowired
//    private UserInfoService userInfoService;
//
//    @Autowired
//    private LastLoginRecordRepository lastLoginRecordRepository;
//
//    @Autowired
//    private SeeRecordRepository seeRecordRepository;
//
//    @Autowired
//    private FreeBeanSettingRepository freeBeanSettingRepository;
//
//    @Autowired
//    private FreeBeanRecordRepository freeBeanRecordRepository;
//
//    @Autowired
//    private SignInRecordService signInRecordService;
//
//    public BaiduUser edit(BaiduUser user, String ip) {
//        BaiduUser db = findByOpenId(user.getUid());
//        int userId;
//        if (db == null) {
//            userId = baiduUserRepository.getMaxId();
//            userId++;
//            user.setId(userId);
//            user.setStatus(UserStatus.WAIT.name());
//            user.setTime(System.currentTimeMillis());
//            baiduUserRepository.create(user);
//            userInfoService.addBean(user.getId(), SiteCache.getSiteSetting().getRegisterDou(), BeanChangeType.REGISTER,true);
//            createLastLoginRecord(user, ip);
//            createFreeBeanSetting(user.getId());
//            return user;
//        } else {
//            db.setUname(user.getUname());
//            db.setPortrait(user.getPortrait());
//            baiduUserRepository.update(db);
//            updateLastLoginRecord(db, ip);
//            return db;
//        }
//    }
//
//    private void createFreeBeanSetting(int id) {
//        FreeBeanSetting setting = new FreeBeanSetting();
//        setting.setId(id);
//        setting.setStartCount(0);
//        setting.setCount(0);
//        setting.setOpen(false);
//        setting.setTime(System.currentTimeMillis());
//    }
//
//    public UserBO findUserBOById(int id) {
//        UserBO userBO = new UserBO();
//        BaiduUser user = baiduUserRepository.findById(id);
//        UserInfo userInfo = userInfoService.findById(id);
//        FreeBeanSetting freeBeanSetting = freeBeanSettingRepository.findById(id);
//        userBO.setUser(user);
//        userBO.setUserInfo(userInfo);
//        userBO.setFreeBeanSetting(freeBeanSetting);
//        userBO.setHasSignIn(signInRecordService.hasSignIn(id));
//        return userBO;
//    }
//
//    private void createLastLoginRecord(BaiduUser user, String ip) {
//        LastLoginRecord lastLoginRecord = new LastLoginRecord();
//        lastLoginRecord.setId(user.getId());
//        lastLoginRecord.setTime(System.currentTimeMillis());
//        lastLoginRecord.setIp(ip);
//        lastLoginRecordRepository.create(lastLoginRecord);
//    }
//
//    private void updateLastLoginRecord(BaiduUser user, String ip) {
//        LastLoginRecord db = lastLoginRecordRepository.findById(user.getId());
//        db.setTime(System.currentTimeMillis());
//        db.setIp(ip);
//        lastLoginRecordRepository.update(db);
//    }
//
//    /**
//     * @param user 登录的人
//     * @param id   被查看信息人的id
//     * @return 被查看的人的信息
//     */
//    public BaiduUser toSee(BaiduUser user, int id) {
//        SeeRecord seeRecord = seeRecordRepository.findByUserId(user.getId(), id);
//        if (seeRecord==null){//之前没有查看过
//            FreeBeanSetting beikanSetting = freeBeanSettingRepository.findById(id);
//            if(beikanSetting!=null
//                    &&beikanSetting.isOpen()
//                    &&beikanSetting.getCount()>0){//被看人开启了免豆设置，扣除被看人设置中的推广豆
//                beikanSetting.setCount(beikanSetting.getCount()-1);
//                if(beikanSetting.getCount()==0){
//                    beikanSetting.setOpen(false);
//                }
//                freeBeanSettingRepository.update(beikanSetting);
//                FreeBeanRecord beanRecord = new FreeBeanRecord();
//                int maxId = freeBeanRecordRepository.getMaxId();
//                maxId++;
//                beanRecord.setId(maxId);
//                beanRecord.setUserId(id);
//                beanRecord.setSeeId(user.getId());
//                beanRecord.setSeeName(user.getUid());
//                beanRecord.setTime(System.currentTimeMillis());
//                freeBeanRecordRepository.create(beanRecord);
//            }else{//扣除查看人的推广豆
//                userInfoService.subBean(user.getId(), 1, BeanChangeType.CONSUME);
//            }
//            createSeeRecord(user.getId(), id);
//        }
//        BaiduUser beenSeeUser = baiduUserRepository.findById(id);
//        return beenSeeUser;
//    }
//
//    /**
//     * @param seeId    查看的人
//     * @param beiKanId 被查看的人
//     */
//    private void createSeeRecord(int seeId, int beiKanId) {
//        SeeRecord seeRecord = new SeeRecord();
//        int maxId = seeRecordRepository.getMaxId();
//        maxId++;
//        seeRecord.setId(maxId);
//        seeRecord.setUserId(seeId);
//        seeRecord.setBeikanId(beiKanId);
//        seeRecord.setTime(System.currentTimeMillis());
//        seeRecordRepository.create(seeRecord);
//    }
//
//    public void updateStatus(int id, UserStatus status) {
//        baiduUserRepository.updateStatus(id, status.name());
//    }
//
//    public void delete(String id) {
//        baiduUserRepository.delete(id);
//    }
//
//    public List<BaiduUser> list(Map<String, Object> parameter) {
//        return baiduUserRepository.list(parameter);
//    }
//
//    public BaiduUser findById(int id) {
//        return baiduUserRepository.findById(id);
//    }
//
//    public BaiduUser findByOpenId(String uid) {
//        return baiduUserRepository.findByOpenId(uid);
//    }
//
//    public int getCount(Map<String, Object> parameter) {
//        return baiduUserRepository.getCount(parameter);
//    }
}
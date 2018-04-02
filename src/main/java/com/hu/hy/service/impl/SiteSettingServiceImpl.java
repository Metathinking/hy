package com.hu.hy.service.impl;

import com.hu.hy.domain.SiteSetting;
import com.hu.hy.repository.SiteSettingRepository;
import com.hu.hy.service.SiteSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SiteSettingServiceImpl.java 2017/03/16 21:54
 */
@Service
public class SiteSettingServiceImpl implements SiteSettingService {

    @Autowired
    private SiteSettingRepository siteSettingRepository;

    private final int id=9527;

    public SiteSetting edit(SiteSetting siteSetting) {
        SiteSetting db = siteSettingRepository.findById(id);
        if(db==null){
            siteSetting.setId(id);
            siteSetting.setTime(System.currentTimeMillis());
            siteSettingRepository.create(siteSetting);
            return siteSetting;
        }else{
            db.setRegisterDou(siteSetting.getRegisterDou());
            db.setSignInStart(siteSetting.getSignInStart());
            db.setSignInStep(siteSetting.getSignInStep());
            db.setSignInEnd(siteSetting.getSignInEnd());
            db.setTime(System.currentTimeMillis());
            siteSettingRepository.update(db);
            return db;
        }
    }

    public SiteSetting find() {
        return siteSettingRepository.findById(id);
    }
}
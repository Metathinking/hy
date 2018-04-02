package com.hu.hy.cache;


import com.hu.hy.domain.SiteInfo;
import com.hu.hy.domain.SiteSetting;
import com.hu.hy.service.SiteInfoService;
import com.hu.hy.service.SiteSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SiteCache.java 2016/07/05 10:47
 */
@Component
public class SiteCache {

    private static Map<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private SiteInfoService siteInfoService;

    @Autowired
    private SiteSettingService siteSettingService;

    private static SiteInfoService staticSiteInfoService;
    private static SiteSettingService staticSiteSettingService;


    @PostConstruct
    public void init() {
        staticSiteInfoService = this.siteInfoService;
        staticSiteSettingService = this.siteSettingService;
    }

    public static void put(String key, Object value) {
        map.put(key, value);
    }

    public static final String SITE_INFO = "siteInfo";
    public static final String SITE_SETTING = "siteSetting";
    public static final String COLUMN_LIST = "columnList";

    public static SiteInfo getSiteInfo() {
        Object object = map.get(SITE_INFO);
        if (object == null) {
            SiteInfo siteInfo = staticSiteInfoService.find();
            map.put(SITE_INFO, siteInfo);
            return siteInfo;
        }
        return (SiteInfo) object;
    }

    public static SiteSetting getSiteSetting() {
        Object object = map.get(SITE_SETTING);
        if (object == null) {
            SiteSetting siteSetting = staticSiteSettingService.find();
            map.put(SITE_SETTING, siteSetting);
            return siteSetting;
        }
        return (SiteSetting) object;
    }

}
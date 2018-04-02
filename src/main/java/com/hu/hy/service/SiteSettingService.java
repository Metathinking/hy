package com.hu.hy.service;

import com.hu.hy.domain.SiteSetting;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SiteSettingService.java 2017/03/16 21:52
 */
public interface SiteSettingService {

    SiteSetting edit(SiteSetting siteSetting);

    SiteSetting find();
}
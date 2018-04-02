package com.hu.hy.repository;


import com.hu.hy.domain.SiteSetting;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SiteSettingRepository.java 2017/03/16 21:52
 */
public interface SiteSettingRepository {

    void create(SiteSetting siteSetting);

    void update(SiteSetting siteSetting);

    SiteSetting findById(int id);
}
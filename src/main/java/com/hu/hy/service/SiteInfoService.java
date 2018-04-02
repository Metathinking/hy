package com.hu.hy.service;


import com.hu.hy.domain.SiteInfo;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SiteInfoService.java 2016/07/03 21:59
 */
public interface SiteInfoService {

    SiteInfo edit(SiteInfo siteInfo);

    SiteInfo find();
}
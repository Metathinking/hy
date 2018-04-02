package com.hu.hy.service;

import com.hu.hy.domain.FreeBeanSetting;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) FreeBeanSettingService.java 2017/03/19 23:17
 */
public interface FreeBeanSettingService {

   FreeBeanSetting update(String id,boolean open,int count);

    List<FreeBeanSetting>  list(Map<String,Object> parameters);

    int getCount(Map<String,Object> parameters);
}
package com.hu.hy.service;


import com.hu.hy.domain.ManagerLoginLog;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ManagerLoginLogService.java 2016/07/04 22:45
 */
public interface ManagerLoginLogService {

    List<ManagerLoginLog> list(Map<String, Object> params);

    int getCount();
}
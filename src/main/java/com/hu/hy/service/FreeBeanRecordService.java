package com.hu.hy.service;

import com.hu.hy.domain.FreeBeanRecord;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) FreeBeanRecordService.java 2017/03/20 00:46
 */
public interface FreeBeanRecordService {

    List<FreeBeanRecord> list(Map<String,Object> parameters);

    int getCount(Map<String,Object> parameters);
}
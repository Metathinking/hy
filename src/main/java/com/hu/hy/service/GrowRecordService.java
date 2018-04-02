package com.hu.hy.service;

import com.hu.hy.domain.GrowRecord;

import java.util.List;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) GrowRecordService.java 2017/03/27 10:10
 */
public interface GrowRecordService {

    List<GrowRecord> getMonthGrowRecordList(int year,int month);
}
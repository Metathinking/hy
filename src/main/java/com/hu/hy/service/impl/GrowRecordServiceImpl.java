package com.hu.hy.service.impl;

import com.hu.hy.domain.GrowRecord;
import com.hu.hy.repository.BaiduUserRepository;
import com.hu.hy.repository.GrowRecordRepository;
import com.hu.hy.service.GrowRecordService;
import com.hu.hy.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) GrowRecordServiceImpl.java 2017/03/27 10:11
 */
@Service
public class GrowRecordServiceImpl implements GrowRecordService {

    @Autowired
    private GrowRecordRepository growRecordRepository;

    @Autowired
    private BaiduUserRepository baiduUserRepository;

    public List<GrowRecord> getMonthGrowRecordList(int year,int month) {
        long start = DateUtil.getMonthStart(year,month);
        long end = DateUtil.getMonthEnd(year,month);
        long now = System.currentTimeMillis();
        if(now < start){
            return new ArrayList<GrowRecord>();
        }
        if(now<end){
            end=now;
        }
        long oneDay=24*60*60*1000;
        long oneDayStart=start;
        long oneDayEnd=0;
        int maxId = growRecordRepository.getMaxId();
        do {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("startTime",oneDayStart);
            oneDayEnd=oneDayStart+oneDay-1;
            map.put("endTime",oneDayEnd);
           GrowRecord db= growRecordRepository.findByTime(oneDayStart,oneDayEnd);
            if (db!=null){
                oneDayStart+=oneDay;
                continue;
            }
            int count = baiduUserRepository.getCount(map);
            GrowRecord growRecord= new GrowRecord();
            maxId++;
            growRecord.setId(maxId);
            growRecord.setStartTime(oneDayStart);
            growRecord.setEndTime(oneDayEnd);
            growRecord.setCount(count);
            growRecordRepository.create(growRecord);
            System.out.println(DateUtil.getDateStringByFormat(growRecord.getStartTime(),"yyyy-MM-dd HH:mm:ss sss a"));
            System.out.println(DateUtil.getDateStringByFormat(growRecord.getEndTime(),"yyyy-MM-dd HH:mm:ss sss a"));
            oneDayStart+=oneDay;
        }while (oneDayEnd<end);
        Map<String,Object> parameters = new HashMap<String, Object>();
        parameters.put("startTime",start);
        parameters.put("endTime",end);
        List<GrowRecord> list=growRecordRepository.list(parameters);
        return list;
    }
}
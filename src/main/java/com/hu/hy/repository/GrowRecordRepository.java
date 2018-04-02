package com.hu.hy.repository;

import com.hu.hy.domain.GrowRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) GrowRecordRepository.java 2017/03/27 10:05
 */
public interface GrowRecordRepository {

    void create(GrowRecord growRecord);

    List<GrowRecord> list(Map<String,Object> parameters);

    int getCount(Map<String,Object> parameters);

    int getMaxId();

    GrowRecord findByTime(@Param("start") long oneDayStart,@Param("end") long oneDayEnd);
}
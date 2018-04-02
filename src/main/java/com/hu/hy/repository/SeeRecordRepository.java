package com.hu.hy.repository;

import com.hu.hy.domain.SeeRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SeeRecordRepository.java 2017/03/15 22:07
 */
@Repository
public interface SeeRecordRepository {

    void create(SeeRecord seeRecord);

    List<SeeRecord> list(Map<String,Object> parameters);

    int getCount(Map<String,Object> parameters);

    int getMaxId();

    SeeRecord findByUserId(@Param("userId") String userId,@Param("beikanId") String beikanUserId);

}
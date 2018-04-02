package com.hu.hy.repository;

import com.hu.hy.domain.SignInRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SignInRecordRepository.java 2017/03/15 22:09
 */
@Repository
public interface SignInRecordRepository {

    void create(SignInRecord signInRecord);

    List<SignInRecord> list(Map<String,Object> parameters);

    int getCount(Map<String,String> parameters);

    int getMaxId();

    SignInRecord findById(int id);

    SignInRecord findLastByUserId(String userId);
}
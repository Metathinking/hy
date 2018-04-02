package com.hu.hy.service;

import com.hu.hy.domain.SignInRecord;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SignInRecordService.java 2017/03/16 21:45
 */
public interface SignInRecordService {

    void create(String  useId);

    List<SignInRecord> list(Map<String,Object> parameters);

    int getCount(Map<String,String> parameters);

    SignInRecord findById(int id);

    boolean hasSignIn(String userId);
}
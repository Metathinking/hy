package com.hu.hy.repository;

import com.hu.hy.domain.ManagerLoginLog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) AdminLoginLogRepository.java 2016/07/04 22:10
 */
@Repository
public interface ManagerLoginLogRepository {

    void create(ManagerLoginLog managerLoginLog);

    List<ManagerLoginLog> list(Map<String, Object> params);

    int getMaxId();

    int getCount();
}
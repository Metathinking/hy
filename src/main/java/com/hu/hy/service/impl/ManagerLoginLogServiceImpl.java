package com.hu.hy.service.impl;

import com.hu.hy.domain.ManagerLoginLog;
import com.hu.hy.repository.ManagerLoginLogRepository;
import com.hu.hy.service.ManagerLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ManagerLoginLogServiceImpl.java 2016/07/04 22:46
 */
@Service
public class ManagerLoginLogServiceImpl implements ManagerLoginLogService {

    @Autowired
    private ManagerLoginLogRepository managerLoginLogRepository;

    public List<ManagerLoginLog> list(Map<String, Object> params) {
        return managerLoginLogRepository.list(params);
    }

    public int getCount() {
        return managerLoginLogRepository.getCount();
    }
}
package com.hu.hy.service.impl;

import com.hu.hy.domain.Power;
import com.hu.hy.repository.PowerRepository;
import com.hu.hy.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) PowerServiceImpl.java 2017/03/26 21:58
 */
@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    private PowerRepository powerRepository;

    public void edit(List<Power> powerList) {
        for(Power power:powerList){
            powerRepository.update(power);
        }
    }

    public List<Power> list(int managerId) {
        return powerRepository.listByManagerId(managerId);
    }
}
package com.hu.hy.service.impl;

import com.hu.hy.domain.Manager;
import com.hu.hy.domain.ManagerLoginLog;
import com.hu.hy.domain.Power;
import com.hu.hy.domain.bo.ManagerBO;
import com.hu.hy.exception.ServiceException;
import com.hu.hy.repository.ManagerLoginLogRepository;
import com.hu.hy.repository.ManagerRepository;
import com.hu.hy.repository.PowerRepository;
import com.hu.hy.service.ManagerService;
import com.hu.hy.type.PowerType;
import com.hu.hy.util.Md5Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) AdminServiceImpl.java 2016/07/04 22:12
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private PowerRepository powerRepository;

    private final String id="renshuang";
    private final String pw="13754678850.";

    @Autowired
    private ManagerLoginLogRepository managerLoginLogRepository;

    public ManagerBO login(Manager manager, String ip) {
        Manager db = managerRepository.find(manager.getName(), manager.getPassword());
        if(db ==null){
            throw new ServiceException(201,"用户名或密码错误");
        }else{
            createLoginLog(db,ip);
            List<Power> powerList = powerRepository.listByManagerId(db.getId());
            ManagerBO bo=new ManagerBO();
            bo.setId(db.getId());
            bo.setName(db.getName());
            bo.setPowers(powerList);
            return bo;
        }
    }

    private void createLoginLog(Manager manager, String ip) {
        ManagerLoginLog managerLoginLog = new ManagerLoginLog();
        int maxId = managerLoginLogRepository.getMaxId();
        maxId++;
        managerLoginLog.setId(maxId);
        managerLoginLog.setManagerId(manager.getId());
        managerLoginLog.setManagerName(manager.getName());
        managerLoginLog.setTime(System.currentTimeMillis());
        managerLoginLog.setIp(ip);
        managerLoginLogRepository.create(managerLoginLog);
    }

    public Manager edit(Manager manager) {
        Manager db = managerRepository.findById(manager.getId());
        if(db==null){
            return create(manager);
        }else{
            db.setName(manager.getName());
            db.setPassword(Md5Factory.encoding(manager.getPassword()));
            managerRepository.update(db);
            return db;
        }
    }

    private Manager create(Manager manager) {
        int maxId = managerRepository.getMaxId();
        maxId++;
        manager.setId(maxId);
        manager.setPassword(Md5Factory.encoding(manager.getPassword()));
        managerRepository.create(manager);
        createPower(manager);
        return manager;
    }

    private void createPower(Manager manager) {
        PowerType[] values = PowerType.values();
        List<Power> powerList = new ArrayList<Power>(values.length);
        int maxId = powerRepository.getMaxId();
        for (PowerType powerType:values){
            maxId++;
            Power power = new Power();
            power.setId(maxId);
            power.setManagerId(manager.getId());
            power.setPower(powerType.name());
            power.setDescription(powerType.getDescription());
            power.setOpen(false);
            powerList.add(power);
        }
        powerRepository.create(powerList);
    }

    public List<Manager> list() {
        return managerRepository.list();
    }

    public void delete(int id) {
        Manager db = managerRepository.findById(id);
        //todo 超级管理员
        managerRepository.delete(id);
        powerRepository.deleteByManagerId(id);
    }

    public Manager findById(int id) {
        Manager db = managerRepository.findById(id);
        db.setPassword("");
        return db;
    }
}
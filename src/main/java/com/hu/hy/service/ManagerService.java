package com.hu.hy.service;


import com.hu.hy.domain.Manager;
import com.hu.hy.domain.bo.ManagerBO;

import java.util.List;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ManagerService.java 2016/07/04 22:12
 */
public interface ManagerService {

    ManagerBO login(Manager manager, String ip);

    Manager edit(Manager manager);

    List<Manager> list();

    void delete(int id);

    Manager findById(int id);
}
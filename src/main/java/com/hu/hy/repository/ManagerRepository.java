package com.hu.hy.repository;

import com.hu.hy.domain.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) AdminRepository.java 2016/07/04 22:08
 */
@Repository
public interface ManagerRepository {

    void create(Manager manager);

    void update(Manager manager);

    Manager find(@Param("name") String name, @Param("password") String password);

    int getCount();

    int getMaxId();

    Manager findById(int id);

    List<Manager> list();

    void delete(int id);
}
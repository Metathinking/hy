package com.hu.hy.repository;

import com.hu.hy.domain.Power;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) PowerRepository.java 2017/03/24 22:41
 */
@Repository
public interface PowerRepository {

    void create(List<Power> list);

    void update(Power power);

    int getMaxId();

    List<Power> listByManagerId(int id);

    void deleteByManagerId(int id);
}
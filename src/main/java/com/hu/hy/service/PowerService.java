package com.hu.hy.service;

import com.hu.hy.domain.Power;

import java.util.List;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) PowerService.java 2017/03/26 21:57
 */
public interface PowerService {

    void edit(List<Power> powerList);

    List<Power> list(int managerId);
}
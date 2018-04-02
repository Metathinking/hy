package com.hu.hy.domain.bo;

import com.hu.hy.domain.Manager;
import com.hu.hy.domain.Power;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) ManagerBO.java 2017/03/26 22:39
 */
public class ManagerBO extends Manager {

    private Map<String,Boolean> powers;

    public Map<String,Boolean> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powerList) {
        powers = new HashMap<String, Boolean>();
        if(powerList==null||powerList.isEmpty()){
            return;
        }
        for(Power power:powerList){
            powers.put(power.getPower(),power.isOpen());
        }
    }
}
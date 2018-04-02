package com.hu.hy.util;

import com.hu.hy.domain.Power;
import com.hu.hy.domain.bo.ManagerBO;
import com.hu.hy.type.PowerType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) PowerUtil.java 2017/03/26 22:45
 */
public class PowerUtil {

    public static boolean hasPower(HttpServletRequest request, PowerType powerType){
        ManagerBO bo = (ManagerBO) request.getSession().getAttribute("ADMIN");
        Map<String, Boolean> powers = bo.getPowers();
        return powers.get(powerType.name());
    }
}
package com.hu.hy.controller.admin;


import com.hu.hy.domain.ManagerLoginLog;
import com.hu.hy.query.PageQuery;
import com.hu.hy.service.ManagerLoginLogService;
import com.hu.hy.type.PowerType;
import com.hu.hy.util.ExceptionTipHandler;
import com.hu.hy.util.PowerUtil;
import com.hu.hy.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) AdminLoginLogController.java 2016/07/04 22:44
 */
@Controller
@RequestMapping("admin/managerLoginLog")
public class ManagerLoginLogController {

    @Autowired
    private ManagerLoginLogService managerLoginLogService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String gotoList(HttpServletRequest request){
        if (!PowerUtil.hasPower(request, PowerType.LOGIN_LOG)){
            return "redirect:/home";
        }
        return "admin/manager-login-log";
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Tip list(@RequestBody PageQuery query){
        try {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("start",query.getStart());
            map.put("size",query.getSize());
            List<ManagerLoginLog> list = managerLoginLogService.list(map);
            int count = managerLoginLogService.getCount();
            query.setCount(count);
            Map<String,Object> backMap = new HashMap<String, Object>();
            backMap.put("list",list);
            backMap.put("pageQuery",query);
            return new Tip(true,100,"查询成功",backMap);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }
}
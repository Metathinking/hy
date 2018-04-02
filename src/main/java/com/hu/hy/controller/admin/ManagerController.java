package com.hu.hy.controller.admin;

import com.hu.hy.domain.Manager;
import com.hu.hy.service.ManagerService;
import com.hu.hy.type.PowerType;
import com.hu.hy.util.ExceptionTipHandler;
import com.hu.hy.util.PowerUtil;
import com.hu.hy.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 管理员
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) AdminController.java 2017/03/24 16:13
 */
@Controller
@RequestMapping("admin/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;


    @RequestMapping(value = "edit",method = RequestMethod.GET)
    public String gotoPage(HttpServletRequest request){
        if (!PowerUtil.hasPower(request, PowerType.POWER_MANAGER)){
            return "redirect:/home";
        }
        return "admin/manager";
    }

    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    public Tip edit(@RequestBody Manager manager){
        if (StringUtils.isEmpty(manager.getName())){
            return new Tip(false,101,"管理员名称不能为空");
        }
        if (StringUtils.isEmpty(manager.getPassword())){
            return new Tip(false,102,"管理员密码不能为空");
        }
        try {
            Manager dbManager=managerService.edit(manager);
            return new Tip(true,100,"保存成功",dbManager);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Tip list(){
        try {
            List<Manager> managers = managerService.list();
            return new Tip(true,100,"成功",managers);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Tip delete(@PathVariable("id") int id){
        try {
            managerService.delete(id);
            return new Tip(true,100,"成功");
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }
}
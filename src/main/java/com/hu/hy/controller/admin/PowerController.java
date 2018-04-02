package com.hu.hy.controller.admin;

import com.hu.hy.domain.Manager;
import com.hu.hy.domain.Power;
import com.hu.hy.service.ManagerService;
import com.hu.hy.service.PowerService;
import com.hu.hy.util.ExceptionTipHandler;
import com.hu.hy.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) PowerController.java 2017/03/26 21:57
 */
@Controller
@RequestMapping("admin/power")
public class PowerController {

    @Autowired
    private PowerService powerService;

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "list/{id}",method = RequestMethod.GET)
    public String gotoList(@PathVariable("id")int id, Model model){
        Manager manager=managerService.findById(id);
        model.addAttribute("manager",manager);
        return "admin/power";
    }

    @RequestMapping(value = "list/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Tip list(@PathVariable("id")int id){
        try {
            List<Power> list = powerService.list(id);
            return new Tip(true,100,"成功",list);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }

    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    public Tip edit(@RequestBody List<Power> list){
        try {
            powerService.edit(list);
            return new Tip(true,100,"成功");
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }
}
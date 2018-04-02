package com.hu.hy.controller.admin;

import com.hu.hy.domain.GrowRecord;
import com.hu.hy.service.GrowRecordService;
import com.hu.hy.service.UserService;
import com.hu.hy.type.PowerType;
import com.hu.hy.util.PowerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) AdminHomeController.java 2017/01/18 14:01
 */
@Controller
public class AdminHomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private GrowRecordService growRecordService;

    @RequestMapping(value ="admin/home" ,method = RequestMethod.GET)
    public String gotoHome(HttpServletRequest request, Model model,
                           @RequestParam(value = "year",required = false) String year,
                           @RequestParam(value = "month",required = false) String month){
        if (!PowerUtil.hasPower(request, PowerType.SITE_HOME)){
            return "redirect:/home";
        }
        int userCount = userService.getCount(new HashMap<String, Object>());
        Calendar calendar = Calendar.getInstance();
        int yearInt=0;
        if(StringUtils.isEmpty(year)){
            yearInt=calendar.get(Calendar.YEAR);
        }else{
            try {
                yearInt=Integer.parseInt(year);
            } catch (NumberFormatException e) {
                yearInt=calendar.get(Calendar.YEAR);
            }
        }
        int monthInt;
        if(StringUtils.isEmpty(month)){
            monthInt=calendar.get(Calendar.MONTH);
        }else{
            try {
                monthInt=Integer.parseInt(month);
            } catch (NumberFormatException e) {
                monthInt=calendar.get(Calendar.MONTH);
            }
        }
        List<GrowRecord> growRecordList = growRecordService.getMonthGrowRecordList(yearInt, monthInt);
        model.addAttribute("userCount",userCount);
        model.addAttribute("growRecordList",growRecordList);
        return "admin/home";
    }

}
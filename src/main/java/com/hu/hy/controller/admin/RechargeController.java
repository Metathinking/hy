package com.hu.hy.controller.admin;

import com.hu.hy.domain.RechargeRecord;
import com.hu.hy.domain.User;
import com.hu.hy.service.RechargeRecordService;
import com.hu.hy.service.UserService;
import com.hu.hy.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) RechargeController.java 2017/03/17 09:37
 */
@Controller
@RequestMapping("recharge")
public class RechargeController {

    @Autowired
    private RechargeRecordService rechargeRecordService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "gotoRecharge/{userId}",method = RequestMethod.GET)
    public String gotoRecharge(@PathVariable(value = "userId") String userId, Model model, HttpServletRequest request){
//        if (!PowerUtil.hasPower(request, PowerType.)){
//            return "home";
//        }
        if(userId==null||userId==""){
            model.addAttribute("errorMsg","请选择用户");
            return "error";
        }else{
            User user = userService.findByOpenId(userId);
            model.addAttribute("id",userId);
            model.addAttribute("user",user);
            return "admin/recharge";
        }
    }

    @RequestMapping(value = "recharge",method = RequestMethod.POST)
    @ResponseBody
    public Tip recharge(@RequestBody RechargeRecord rechargeRecord){
        try {
            RechargeRecord db = rechargeRecordService.create(rechargeRecord);
            return new Tip(true,100,"充值成功",db);
        } catch (Exception e) {
            e.printStackTrace();
            return new Tip(false,101,e.getMessage());
        }

    }
}
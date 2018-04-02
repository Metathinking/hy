package com.hu.hy.controller;

import com.hu.hy.domain.BaiduUser;
import com.hu.hy.domain.FreeBeanSetting;
import com.hu.hy.domain.User;
import com.hu.hy.domain.UserInfo;
import com.hu.hy.service.*;
import com.hu.hy.type.UserStatus;
import com.hu.hy.util.ExceptionTipHandler;
import com.hu.hy.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UserController.java 2017/03/11 23:51
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SignInRecordService signInRecordService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private FreeBeanSettingService freeBeanSettingService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String gotoAdd() {
        return "user-add";
    }

//    @RequestMapping(value = "add",method = RequestMethod.POST)
//    @ResponseBody
//    public Tip add(@RequestBody User user){
//        if (StringUtils.isEmpty(user.getWeixinNo())){
//           return new Tip(false,101,"微信号不能为空");
//        }
//        if (StringUtils.isEmpty(user.getCode())){
//            return new Tip(false,102,"需要上传微信二维码");
//        }
//        if(StringUtils.isEmpty(user.getArea())){
//            return new Tip(false,103,"请选择所在地区");
//        }
//        if(StringUtils.isEmpty(user.getTrade())){
//            return new Tip(false,104,"请选择所在行业");
//        }
//        if(user.getSex()!=0&&user.getSex()!=1){
//            return new Tip(false,105,"请选择您的性别");
//        }
//        User db = userService.create(user);
//        return new Tip(true,100,"欢迎加入",db);
//    }

    /**
     * 每日签到
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "signIn/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Tip signIn(@PathVariable(value = "id") String id) {
        try {
            signInRecordService.create(id);
            UserInfo userInfo = userInfoService.findById(id);
            return new Tip(true, 100, "签到成功", userInfo);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }

    @RequestMapping(value = "hide/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Tip hide(@PathVariable(value = "id") String id) {
        User user = userService.findByOpenId(id);
        if (UserStatus.SHOW.name().equals(user.getStatus())) {
            userService.updateStatus(id, UserStatus.HIDE);
            user.setStatus(UserStatus.HIDE.name());
            return new Tip(true, 100, "您已隐身", user);
        } else {
            return new Tip(false, 101, "用户状态不可隐藏");
        }
    }


    @RequestMapping(value = "show/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Tip show(@PathVariable(value = "id") String id) {
        User user = userService.findByOpenId(id);
        if (UserStatus.HIDE.name().equals(user.getStatus())) {
            userService.updateStatus(id, UserStatus.SHOW);
            user.setStatus(UserStatus.SHOW.name());
            return new Tip(true, 100, "您已显示", user);
        } else {
            return new Tip(false, 101, "系统错误");
        }
    }

    @RequestMapping(value = "apply/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Tip apply(@PathVariable(value = "id") String id) {
        User user = userService.findByOpenId(id);
        if (UserStatus.NO_PASS.name().equals(user.getStatus()) ||
                UserStatus.CANCEL.name().equals(user.getStatus())) {
            userService.updateStatus(id, UserStatus.WAIT);
            user.setStatus(UserStatus.WAIT.name());
            return new Tip(true, 100, "请等待审核", user);
        } else {
            return new Tip(false, 101, "系统错误");
        }
    }


    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable(value = "id") String id, Model model, HttpSession session) {
        Object object = session.getAttribute("USER");
        if (object == null) {
            model.addAttribute("errorMsg", "请先登录");
            return "redirect:/home";
        } else {
            User user = (User) object;
            if (user.getOpenid().equals(id)) {
                model.addAttribute("aUser", user);
            } else {
                User beenSeeUser = userService.toSee(user, id);
                model.addAttribute("aUser", beenSeeUser);
            }
            return "user-message";
        }
    }

    /**
     * 修改免豆查看设置
     *
     * @param count
     * @param open
     * @param session
     * @return
     */
    @RequestMapping(value = "freeBean/change", method = RequestMethod.POST)
    @ResponseBody
    public Tip changeFreeBean(@RequestParam("count") int count, @RequestParam("open") boolean open, HttpSession session) {
        try {
            User user = (User) session.getAttribute("USER");
            FreeBeanSetting beanSetting = freeBeanSettingService.update(user.getOpenid(), open, count);
            UserInfo userInfo = userInfoService.findById(user.getOpenid());
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userInfo", userInfo);
            map.put("freeBeanSetting", beanSetting);
            return new Tip(true, 100, "更新成功", map);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }

    @RequestMapping(value = "uc/editMsg", method = RequestMethod.POST)
    @ResponseBody
    public Tip editMsg(@RequestBody User user) {
        try {
            User db = userService.editMsg(user);
            return new Tip(true, 100, "更新成功", db);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }

}
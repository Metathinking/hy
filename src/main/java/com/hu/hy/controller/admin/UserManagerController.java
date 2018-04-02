package com.hu.hy.controller.admin;

import com.hu.hy.domain.User;
import com.hu.hy.query.PageQuery;
import com.hu.hy.service.UserService;
import com.hu.hy.type.PowerType;
import com.hu.hy.type.UserStatus;
import com.hu.hy.util.ExceptionTipHandler;
import com.hu.hy.util.PowerUtil;
import com.hu.hy.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) UserManagerController.java 2017/03/17 08:52
 */
@Controller
@RequestMapping("admin/userManager")
public class UserManagerController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String gotoList(HttpServletRequest request) {
        if (!PowerUtil.hasPower(request, PowerType.USER_MANAGER)){
            return "redirect:/home";
        }
        return "admin/user-manager";
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public Tip list(@RequestBody PageQuery query) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", query.getStart());
            map.put("size", query.getSize());
            List<User> list = userService.list(map);
            int count = userService.getCount(map);
            query.setCount(count);
            Map<String, Object> backMap = new HashMap<String, Object>();
            backMap.put("list", list);
            backMap.put("pageQuery", query);
            return new Tip(true, 100, "查询成功", backMap);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }

    @RequestMapping(value = "verify/{id}/{pass}", method = RequestMethod.POST)
    @ResponseBody
    public Tip verify(@PathVariable(value = "id") String id, @PathVariable(value = "pass") boolean pass) {
        try {
            User user = userService.findByOpenId(id);
            if (!UserStatus.WAIT.name().equals(user.getStatus())) {
                return new Tip(false, 101, "用户状态为：" + user.getStatus() + ",无法审核");
            }
            UserStatus status;
            if (pass) {
                status = UserStatus.SHOW;
            } else {
                status = UserStatus.NO_PASS;
            }
            userService.updateStatus(id, status);
            return new Tip(true, 100, "操作成功", status.name());
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }

    @RequestMapping(value = "cancel/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Tip cancel(@PathVariable(value = "id") String id) {
        User user = userService.findByOpenId(id);
        if (UserStatus.SHOW.name().equals(user.getStatus()) ||
                UserStatus.HIDE.name().equals(user.getStatus())) {
            userService.updateStatus(id, UserStatus.CANCEL);
            return new Tip(true, 100, "用户已屏蔽", UserStatus.CANCEL.name());
        } else {
            return new Tip(false, 101, "用户状态为：" + user.getStatus() + ",无法屏蔽");
        }
    }
}
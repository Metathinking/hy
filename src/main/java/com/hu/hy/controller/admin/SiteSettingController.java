package com.hu.hy.controller.admin;

import com.hu.hy.cache.SiteCache;
import com.hu.hy.domain.SiteSetting;
import com.hu.hy.service.SiteSettingService;
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
import javax.servlet.http.HttpSession;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) SiteSettingController.java 2016/07/03 22:25
 */
@Controller
@RequestMapping("admin/siteSetting")
public class SiteSettingController {

    @Autowired
    private SiteSettingService siteSettingService;

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String gotoEdit(HttpServletRequest request) {
        if (!PowerUtil.hasPower(request, PowerType.SITE_SETTING)){
            return "redirect:/home";
        }
        return "admin/site-setting-edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public Tip edit(@RequestBody SiteSetting siteSetting, HttpSession session) {
        try {
            if (siteSetting.getRegisterDou() < 0) {
                siteSetting.setRegisterDou(0);
            }
            if (siteSetting.getSignInStart() < 0) {
                siteSetting.setSignInStart(0);
            }
            if (siteSetting.getSignInStep() < 0) {
                siteSetting.setSignInStep(0);
            }
            if (siteSetting.getSignInEnd() < 0) {
                siteSetting.setSignInStep(30);
            }
            if (siteSetting.getScale() < 1) {
                siteSetting.setScale(1);
            }
            SiteSetting dbSiteSetting = siteSettingService.edit(siteSetting);
            updateSessionAndCache(session, dbSiteSetting);
            return new Tip(true, 100, "更新成功", dbSiteSetting);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }

    private void updateSessionAndCache(HttpSession session, SiteSetting siteSetting) {
        SiteCache.put(SiteCache.SITE_SETTING, siteSetting);
        session.setAttribute(SiteCache.SITE_SETTING, siteSetting);
    }

    @RequestMapping(value = "find", method = RequestMethod.POST)
    @ResponseBody
    public Tip find() {
        try {
            SiteSetting siteSetting = siteSettingService.find();
            return new Tip(true, 100, "查询成功", siteSetting);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }
}
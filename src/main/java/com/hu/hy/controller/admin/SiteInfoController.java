package com.hu.hy.controller.admin;


import com.hu.hy.cache.SiteCache;
import com.hu.hy.domain.SiteInfo;
import com.hu.hy.service.SiteInfoService;
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
 * @(#) SiteController.java 2016/07/03 22:21
 */
@Controller
@RequestMapping("admin/siteInfo")
public class SiteInfoController {

    @Autowired
    private SiteInfoService siteInfoService;

    @RequestMapping(value="edit",method = RequestMethod.GET)
    public String gotoEdit(HttpServletRequest request){
        if (!PowerUtil.hasPower(request, PowerType.SITE_SETTING)){
            return "redirect:/home";
        }
        return "admin/site-info-edit";
    }

    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    public Tip edit(@RequestBody SiteInfo siteInfo, HttpSession session){
        try{
            SiteInfo dbSiteInfo = siteInfoService.edit(siteInfo);
            updateSessionAndCache(session,dbSiteInfo);
            return new Tip(true,100,"更新成功",dbSiteInfo);
        }catch (Exception e){
            return ExceptionTipHandler.handler(e);
        }
    }

    private void updateSessionAndCache(HttpSession session,SiteInfo siteInfo){
        session.setAttribute(SiteCache.SITE_INFO,siteInfo);
        SiteCache.put(SiteCache.SITE_INFO,siteInfo);
    }

    @RequestMapping(value = "find",method = RequestMethod.POST)
    @ResponseBody
    public Tip find(){
        try {
            SiteInfo siteInfo = siteInfoService.find();
            return new Tip(true,100,"查询成功",siteInfo);
        } catch (Exception e) {
            return ExceptionTipHandler.handler(e);
        }
    }
}
package com.hu.hy.service.impl;

import com.hu.hy.domain.FreeBeanSetting;
import com.hu.hy.repository.FreeBeanSettingRepository;
import com.hu.hy.service.FreeBeanSettingService;
import com.hu.hy.service.UserInfoService;
import com.hu.hy.type.BeanChangeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) FreeBeanSettingServiceImpl.java 2017/03/19 23:20
 */
@Service
public class FreeBeanSettingServiceImpl implements FreeBeanSettingService {

    @Autowired
    private FreeBeanSettingRepository freeBeanSettingRepository;


    @Autowired
    private UserInfoService userInfoService;

    /**
     * 开启|关闭 免豆查看设置
     * @param id 用户id,等同 freeBeanSetting id
     * @param open 开启|关闭
     * @param count 开启时，免豆查看的数量
     */
    public FreeBeanSetting update(String id, boolean open, int count) {
        FreeBeanSetting setting = freeBeanSettingRepository.findById(id);
        if(open==setting.isOpen()){
            return setting;
        }
        if(open){
            setting.setStartCount(count);
            setting.setCount(count);
            userInfoService.subBean(id,count, BeanChangeType.DONG_JIE);
        }else{
            int afterCount = setting.getCount();
            setting.setStartCount(0);
            setting.setCount(0);
            if(afterCount>0){
                userInfoService.addBean(id,afterCount,BeanChangeType.JIE_DONG,false);
            }
        }
        setting.setOpen(open);
        setting.setTime(System.currentTimeMillis());
        freeBeanSettingRepository.update(setting);
        return setting;
    }

    public List<FreeBeanSetting> list(Map<String, Object> parameters) {
        return freeBeanSettingRepository.list(parameters);
    }

    public int getCount(Map<String, Object> parameters) {
        return freeBeanSettingRepository.getCount(parameters);
    }
}
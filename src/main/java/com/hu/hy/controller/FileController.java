package com.hu.hy.controller;

import com.hu.hy.util.DateUtil;
import com.hu.hy.util.Tip;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) FileController.java 2017/01/19 17:41
 */
@Controller
public class FileController {



    @RequestMapping(value = "uploadImage",method = RequestMethod.POST)
    @ResponseBody
    public Tip uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if(file!=null &&!file.isEmpty()){
            try{
                String name = file.getOriginalFilename();
                String suffix= name.substring(name.lastIndexOf("."));
                String fileName=DateUtil.getyMdHmsateDate()+suffix;
                String filePath = "resources\\upload\\"+ fileName;

                file.transferTo(new File(rootDirectory+filePath));

//                String contextPath = request.getContextPath();
//                String serverUrl = request.getScheme()+"://"+request.getServerName()+contextPath;
                return new Tip(true,100,"保存成功","/resources/upload/"+fileName);
            }catch (Exception e){
                e.printStackTrace();
                return new Tip(false,101,"上传失败："+e.getMessage());
            }
        }
        return new Tip(false,102,"文件不存在");
    }
}
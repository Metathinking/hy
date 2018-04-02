package com.hu.hy.controller;


import com.google.gson.Gson;
import com.hu.hy.domain.BaidiuToken;
import com.hu.hy.domain.BaiduUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类的功能，目的，描述等写在此处
 *
 * @author 胡玉波
 * @version 1.0
 * @(#) HomeController.java 2017/01/16 20:00
 */
@Controller
public class HomeController {

//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
//    public String gotoHome(@RequestParam(value = "index",required = false) Integer index,
//                           @RequestParam(value = "name",required = false) String name,
//                           @RequestParam(value = "searchType",required = false) String searchType, Model model) {
//        UserPageQuery query = new UserPageQuery();
//        if(index==null){
//            index=0;
//        }
//        query.setIndex(index);
//        query.setName(name);
//        query.setSearchType(searchType);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("start", query.getStart());
//        map.put("size", query.getSize());
////        map.put("platform", query.getPlatform());
//        if (!StringUtils.isEmpty(query.getName()) && !StringUtils.isEmpty(query.getName().trim())) {
//            map.put("name", query.getName());
//            map.put("searchType", query.getSearchType());
//        }
//        if (query.getOrders() != null && query.getOrders().length != 0) {
//            map.put("orders", query.getOrders());
//        }
//        List<User> list = userService.list(map);
//        int count = userService.getCount(map);
//        query.setCount(count);
//        query.setPageInfo();
//        model.addAttribute("list", list);
//        model.addAttribute("pageQuery", query);
//        return "home";
//    }


}
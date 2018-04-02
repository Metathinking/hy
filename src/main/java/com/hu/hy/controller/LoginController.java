package com.hu.hy.controller;

import com.google.gson.Gson;
import com.hu.hy.domain.User;
import com.hu.hy.domain.UserBO;
import com.hu.hy.domain.WeiXinToken;
import com.hu.hy.query.PageQuery;
import com.hu.hy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
 * @(#) LoginController.java 2017/03/15 10:44
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 临时
     *
     * @return
     */
    @RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
    public String home(Model model) {
        PageQuery query = new PageQuery();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", query.getStart());
        map.put("size", query.getSize());
        List<User> list = userService.list(map);
        int count = userService.getCount(map);
        query.setCount(count);
        query.setPageInfo();
        model.addAttribute("list", list);
        model.addAttribute("pageQuery", query);
        return "home1";
    }

//    /**
//     * 进入第三方登录页面
//     *
//     * @param platform
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "to_login/{platform}", method = RequestMethod.GET)
//    public String toLogin(@PathVariable(value = "platform") String platform, Model model) {
//        if ("baidu".equals(platform)) { //todo 临时屏蔽
//            return "redirect:" + loginUrl;
//        } else if ("weixin".equals(platform)) {
//            return "redirect:" + weixinLoginUrl;
//        } else {
//            model.addAttribute("msg", "暂时不支持:" + platform);
//            return "error";
//        }
//    }

    /**
     * 进入第三方登录页面
     *todo 测试用例
     * @param platform
     * @param model
     * @return
     */
    @RequestMapping(value = "to_login/{platform}", method = RequestMethod.GET)
    public String toLogin(@PathVariable(value = "platform") String platform, Model model,HttpServletRequest request,
                          HttpSession session) {
        User user = userService.findByOpenId("oFUtVwBuWjPKAUBpSedvKdePdvhY");
        session.setAttribute("USER", user);
        return "redirect:/uc/" + user.getOpenid();
    }


//    /**
//     * 第三方登录成功后，回调url，获取授权code,换取access_token
//     *
//     * @param platform
//     * @param code
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "third_login/{platform}", method = RequestMethod.GET)
//    public String thirdLogin(@PathVariable(value = "platform") String platform,
//                             @RequestParam(value = "code") String code,
//                             Model model,
//                             HttpServletRequest request,
//                             HttpSession session) {
//        String getTokenUrl = "https://openapi.baidu.com/oauth/2.0/token?grant_type=authorization_code&code=" + code +
//                "&client_id=" + apiKey + "&client_secret=" + secretKey + "&redirect_uri=" + redirectUri;
//        try {
//            BaidiuToken token = getObject(getTokenUrl, BaidiuToken.class);
//            String access_token = token.getAccess_token();
//            BaiduUser baiduUser = getObject(getLoggedInUser + access_token, BaiduUser.class);
//            saveImage(baiduUser.getPortrait(), request);
//            BaiduUser user = baiduUserService.edit(baiduUser, request.getRemoteAddr());
//            session.setAttribute("USER",user);
//
//            return "redirect:/uc/"+user.getId();
//        } catch (MalformedURLException e) {
//            model.addAttribute("授权登录失败");
//            e.printStackTrace();
//        } catch (IOException e) {
//            model.addAttribute("授权登录失败");
//            e.printStackTrace();
//        }
//        return "error";
//    }

    /**
     * 第三方登录成功后，回调url，获取授权code,换取access_token
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = "weixin_login", method = RequestMethod.GET)
    public String weixinLogin(@RequestParam(value = "code") String code,
                              Model model,
                              HttpServletRequest request,
                              HttpSession session) {
        String getTokenUrl = String.format(weixinGetAccessToken, code);
        try {
            WeiXinToken token = getObject(getTokenUrl, WeiXinToken.class);
            String access_token = token.getAccess_token();
            User user = getObject(String.format(weixinGetUserInfo, access_token, token.getOpenid()), User.class);
            saveImage(user.getHeadimgurl(), request);
            System.out.println(user);
            User db = userService.edit(user, request.getRemoteAddr());
            session.setAttribute("USER", db);

            return "redirect:/uc/" + db.getOpenid();
        } catch (MalformedURLException e) {
            model.addAttribute("授权登录失败");
            e.printStackTrace();
        } catch (IOException e) {
            model.addAttribute("授权登录失败");
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping(value = "uc/{id}", method = RequestMethod.GET)
    public String userCenter(@PathVariable(value = "id") String id, Model model) {
        if (StringUtils.isEmpty(id)) {
            return "redirect:/home";
        }
        try {
            UserBO userBO = userService.findUserBOById(id);

            model.addAttribute("userBO", userBO);
            return "userCenter";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.setAttribute("USER", null);
        return "redirect:/home";
    }

    /**
     * 获取数据
     *
     * @param urlString
     * @param t
     * @param <T>
     * @return
     * @throws IOException
     */
    private <T> T getObject(String urlString, Class<T> t) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] buff = new byte[inputStream.available()];
        inputStream.read(buff);
        String result = new String(buff, "utf-8");
        Gson gson = new Gson();
        T obj = gson.fromJson(result, t);
        inputStream.close();
        urlConnection.disconnect();
        return obj;
    }

    private void saveImage(String portrait, HttpServletRequest request) {
        String urlString = getportrait + portrait;
        String basePath = request.getServletContext().getRealPath("/resources");
        String directoryPath = basePath + File.separator + "portrait";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String fileName = directory + File.separator + portrait;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            byte[] buff = new byte[1024];
            int cnt;
            while ((cnt = inputStream.read(buff)) > 0) {
                baos.write(buff, 0, cnt);
            }
            inputStream.close();
            connection.disconnect();
            baos.close();
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(baos.toByteArray());
            fos.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * template="http://test.com/auth?client_id=${cid}&redirect_uri=${ruri}$auth_type=code"
     * regex=${(.+?)},匹配${cid},${ruri},匹配后，group(0)为${cid},group(1)为cid
     *
     * @param template
     * @param params
     * @return
     */
    private String templateHandle(String template, Map<String, String> params) {
        Pattern regex = Pattern.compile("\\$\\{(.+?)\\}");
        Matcher matcher = regex.matcher(template);
        StringBuffer sb = new StringBuffer();//用来缓存替换后的结果
        while (matcher.find()) {          //从字符串开头查找每个匹配项
            String key = matcher.group(1);//找到每个匹配项后，从匹配值中取出药替换的变量名：如:cid
            String replaceVal = params.get(key);//根据变量名到map中查找药替换的值，
            if (replaceVal == null) {
                //未在参数map中查找到替换值则不替换此参数
                continue;
            } else {
                //用指定值替换匹配部分，如：将${cid}替换成真实的cid值xxxx,并将替换后结果缓存入sb
                matcher.appendReplacement(sb, replaceVal);
            }
        }
        //最后一个匹配项替换完成后，sb中已存入到最后匹配项位置的所有替换结果
        //最后匹配项以后的字符还没有加入，通过以下操作，将剩余字符加入，完成完整替换过程
        matcher.appendTail(sb);
        return sb.toString();
    }


    private final String apiKey = "pHLcqQaBq0w9wM8uPSAi0XNK";
    private final String secretKey = "A6TPSugbaLb0DGm5cSGH6hHmOgyGoGbi";
    private final String redirectUri = "http://localhost:8080/third_login/baidu";

    private final String loginUrl = "http://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id=" + apiKey
            + "&redirect_uri=" + redirectUri;

    private final String getLoggedInUser = "https://openapi.baidu.com/rest/2.0/passport/users/getLoggedInUser?access_token=";
    private final String getportrait = "http://tb.himg.baidu.com/sys/portrait/item/";

    //微信登录
    private final String weixinAppid = "wx5bddc5ad9771826b";
    private final String weixinAppSecret = "996413c3561e307dd443702c7b0bce44";
    private final String weixinRedirectUri = "http://www.wxfindyou.com/weixin_login";
//    private final String weixinRedirectUri = "http://localhost:8080/weixin_login";
    private final String weixinLoginUrl = "https://open.weixin.qq.com/connect/qrconnect?appid=" + weixinAppid +
            "&redirect_uri=" + weixinRedirectUri + "&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect";

    private final String weixinGetAccessToken = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + weixinAppid
            + "&secret=" + weixinAppSecret + "&code=%s&grant_type=authorization_code";
    private final String weixinGetUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s";
}
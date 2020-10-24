package com.biubixin.springboot.controller;

import com.biubixin.springboot.utils.MyHttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    Gson gson;

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session,
                        @RequestParam("g-recaptcha-response")String googleyzm){
        if (!StringUtils.isEmpty(username)&&"123".equals(password)){
            String a= "secret=1q434f2343dgJvewegwgdgB19Ib-ewgu1tq&response="+googleyzm;
            String rjson = MyHttpUtil.sendPost("https://recaptcha.net/recaptcha/api/siteverify",a);
            Map<String,Object>googlemap = gson.fromJson(rjson,new TypeToken<HashMap<String,Object>>(){}.getType());
            if (googlemap.get("success") .equals(true) ){
                session.setAttribute("loginUser",username);
                return "redirect:/main.html";
            }else {
                map.put("massage","验证码未通过");
                return "login";
            }
        }else {
            map.put("massage","用户名或密码错误");
            return "login";
        }
    }


}

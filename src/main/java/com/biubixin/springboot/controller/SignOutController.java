package com.biubixin.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


//注销按钮
@Controller
public class SignOutController {

    @RequestMapping("/signout")
    public String signout(HttpServletRequest request){
        request.getSession().removeAttribute("loginUser");
        return "redirect:/";
    }
}

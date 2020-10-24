package com.biubixin.springboot.controller;


import com.biubixin.springboot.exception.UserNotException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String t(@RequestParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotException();
        }
        return "hello";
    }
}

package com.biubixin.springboot.controller;

import com.biubixin.springboot.exception.UserNotException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {


/*    //浏览器和客户端都会返回json数据
    @ResponseBody
    @ExceptionHandler(UserNotException.class)
    public Map<String,Object> handleExcption(Exception e){
        Map<String,Object>map = new HashMap<>();
        map.put("code","user.notuser");
        map.put("message",e.getMessage());
        return map;
    }*/

    //浏览器和客户端都会返回json数据
    @ExceptionHandler(UserNotException.class)
    public String handleExcption(Exception e , HttpServletRequest request){
        Map<String,Object>map = new HashMap<>();
        //传入我们自己的错误状态码
         /*Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");*/
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notuser");
        map.put("message","用户出错啦");
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}

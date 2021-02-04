package com.ujiuye.prometion.controller;

import com.ujiuye.prometion.pojo.Employee;
import com.ujiuye.prometion.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/tologin")
    public String tologin(){
        return "login.html";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password, String isremember,
                        HttpSession session, HttpServletResponse response){
        Employee employee = employeeService.login(username, password);
        if(employee==null){//用户名或密码不正确
            return "false";
        }
        //登录成功
        session.setAttribute("LOGIN_USER",employee);

        if("on".equals(isremember)){//记住密码
            Cookie userNameCookie=new Cookie("username",employee.getUsername());
            userNameCookie.setPath("/");
            userNameCookie.setMaxAge(60*60*24*7);
            response.addCookie(userNameCookie);
        }
        return "true";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response){
        session.setAttribute("LOGIN_USER",null);
        Cookie userNameCookie=new Cookie("username",null);
        userNameCookie.setPath("/");
        userNameCookie.setMaxAge(0);
        response.addCookie(userNameCookie);
        return "redirect:/auth/tologin";//重新请求登录
    }
}

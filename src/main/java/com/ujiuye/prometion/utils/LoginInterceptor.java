package com.ujiuye.prometion.utils;

import com.ujiuye.prometion.pojo.Employee;
import com.ujiuye.prometion.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private EmployeeService employeeService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取uri
        String uri = request.getRequestURI();  //localhost/index.html   localhost/employyee/auth/login
        System.out.println(uri);
        String[] openURI={"js","img","images","fonts","css","auth","/WEB-INF/html/"};
        for (String openuri : openURI) {//只要uri中包括数据中的一个就放行
            if(uri.contains(openuri)){
                System.out.println("uri放行");
                return true;
            }
        }
        //uri被拦截，判断有没有登录
        Object login_user = request.getSession().getAttribute("LOGIN_USER");
        if(login_user!=null){//登录了
            System.out.println("登录了放行");
            return true;
        }
        //没有登录，查看cookie,看之前是否存了cookie,cookie就登录
        String username=null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length>0){//判断cookie有没有内空
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("username")){
                    username=cookie.getValue();
                }
            }
        }
        //判断有没有找到username
        if(username!=null){//找到，重新登录
            Employee employee = employeeService.getByUserName(username);
            request.getSession().setAttribute("LOGIN_USER",employee);
            System.out.println("cookie登录放行");
            return true;
        }
        //跳转到登页面
        response.sendRedirect("/auth/tologin");


        return false;
    }
}

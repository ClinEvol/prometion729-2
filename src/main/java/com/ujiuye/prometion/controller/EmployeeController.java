package com.ujiuye.prometion.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.prometion.pojo.AgeDistribution;
import com.ujiuye.prometion.pojo.Employee;
import com.ujiuye.prometion.pojo.SexNumber;
import com.ujiuye.prometion.service.EmployeeService;
import com.ujiuye.prometion.utils.MyFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/employee")
@RestController   //这类下面的方法全部为异步方法
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/list")
    public PageInfo<Employee> list(@RequestParam(value = "pageNum",defaultValue = "1")
                                               int pageNum,
                                   String keyword,
                                   @RequestParam(value = "type",defaultValue = "0")
                                               int type){
        PageHelper.startPage(pageNum,5);
        List<Employee> list = employeeService.list(type,keyword);
        PageInfo<Employee> page=new PageInfo<>(list);
        return page;
    }

    @RequestMapping("/update")
    public String update(Employee employee,Integer[] roles){
        List<Integer> list = Arrays.asList(roles);
        try {
            employeeService.update(employee,list);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping("/save")
    public String save(Employee employee,Integer[] roles){
        try {
            List<Integer> list = Arrays.asList(roles);
            employeeService.save(employee,list);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping("/remove")
    public String remove(int eid){
        try {
            int remove = employeeService.remove(eid);
            if(remove<0){//代表有关联数据
                return "error";
            }
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping("/getByEid")
    public Employee getByEid(int eid){
         return employeeService.getByEid(eid);
    }


    @RequestMapping("/updateLogo")
    public String updateLogo(Employee employee,HttpSession session){
        try {
            Employee sysUser = (Employee) session.getAttribute("LOGIN_USER");
            employee.setEid(sysUser.getEid());
            employeeService.updateLogo(employee);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }

    @Value("${upload.url}")//读取file.properties中的upload.url的值
    private String url;

    @RequestMapping("/upload")
    public String upload(MultipartFile myfile){
        File file = MyFileUtils.uploadFile(myfile, url);
        if(file==null){
            return "false";
        }
        String picUrl="/upload/"+file.getName();
        return picUrl;
    }

    @RequestMapping("/getLoginUser")
    public Employee getLoginUser(HttpSession session){
        Employee employee = (Employee) session.getAttribute("LOGIN_USER");
        return employeeService.getByEid(employee.getEid());
    }


    //性别分布
    @RequestMapping("/sexNumberList")
    public List<SexNumber> sexNumberList(){
        try {
            return employeeService.sexNumberList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //年龄分布
    @RequestMapping("/ageDistributionList")
    public List<AgeDistribution> AgeDistributionList(){
        try {
            return employeeService.AgeDistributionList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }





}

package com.ujiuye.prometion.service;

import com.ujiuye.prometion.pojo.AgeDistribution;
import com.ujiuye.prometion.pojo.Employee;
import com.ujiuye.prometion.pojo.SexNumber;

import java.io.File;
import java.util.List;

public interface EmployeeService {
    List<Employee> list(int type,String keyword);

    int save(Employee employee,List<Integer> list);

    int update(Employee employee,List<Integer> list);
    int updateLogo(Employee employee);

    int remove(int eid);

    Employee getByEid(int eid);

    Employee login(String username,String password);
    Employee getByUserName(String username);
    //返回一个Excel文件，用于下载
    File getExcel(int pageNum);

    //性别分布
    List<SexNumber> sexNumberList();
    //年龄分布
    List<AgeDistribution> AgeDistributionList();

}

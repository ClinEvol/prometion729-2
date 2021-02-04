package com.ujiuye.prometion.service;

import com.ujiuye.prometion.pojo.EmployeeRole;

import java.util.List;

public interface EmployeeRoleService {
    List<EmployeeRole> listByEmpFk(int emp_fk);
    int save(EmployeeRole employeeRole);
    int removeByEmpFk(int emp_fk);
}

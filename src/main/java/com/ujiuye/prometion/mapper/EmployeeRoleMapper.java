package com.ujiuye.prometion.mapper;

import com.ujiuye.prometion.pojo.EmployeeRole;

import java.util.List;

public interface EmployeeRoleMapper {
    List<EmployeeRole> listByEmpFk(int emp_fk);
    int save(EmployeeRole employeeRole);
    int removeByEmpFk(int emp_fk);
}

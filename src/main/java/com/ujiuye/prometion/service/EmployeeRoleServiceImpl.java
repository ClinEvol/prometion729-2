package com.ujiuye.prometion.service;

import com.ujiuye.prometion.mapper.EmployeeRoleMapper;
import com.ujiuye.prometion.pojo.EmployeeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;
    @Override
    public List<EmployeeRole> listByEmpFk(int emp_fk) {
        return employeeRoleMapper.listByEmpFk(emp_fk);
    }

    @Override
    public int save(EmployeeRole employeeRole) {
        return employeeRoleMapper.save(employeeRole);
    }

    @Override
    public int removeByEmpFk(int emp_fk) {
        return employeeRoleMapper.removeByEmpFk(emp_fk);
    }
}

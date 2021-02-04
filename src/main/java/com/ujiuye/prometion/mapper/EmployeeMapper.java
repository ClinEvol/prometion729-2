package com.ujiuye.prometion.mapper;

import com.ujiuye.prometion.pojo.Employee;
import com.ujiuye.prometion.pojo.SexNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> list(@Param("name") String name,
                        @Param("tel")String tel,
                        @Param("hirdate")String hirdate);

    int save(Employee employee);

    int update(Employee employee);

    int remove(int eid);

    Employee getByEid(int eid);

    Employee getByUserName(String username);


    List<SexNumber> sexNumberList();

    int countAge(@Param("begin") int begin,@Param("end") int end);
}

package com.ujiuye.prometion.mapper;

import com.ujiuye.prometion.pojo.Dept;
import com.ujiuye.prometion.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int save(Role role);
    int update(Role role);
    int remove(int id);
    //批量删除
    int removeList(@Param("ids") List<Integer> ids);
    List<Role> list();
    Role getById(int id);
}

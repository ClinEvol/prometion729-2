package com.ujiuye.prometion.service;

import com.ujiuye.prometion.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptService {
    int save(Dept dept);
    int update(Dept dept);
    int remove(int no);
    //批量删除
    int removeList(@Param("nos") List<Integer> nos);
    List<Dept> list();
    Dept getByNo(int no);
}

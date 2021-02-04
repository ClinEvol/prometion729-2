package com.ujiuye.prometion.mapper;

import com.ujiuye.prometion.pojo.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DeptMapper {
    int save(Dept dept);
    int update(Dept dept);
    int remove(int no);
    //批量删除
    int removeList(@Param("nos") List<Integer> nos);
    List<Dept> list();
    Dept getByNo(int no);
}

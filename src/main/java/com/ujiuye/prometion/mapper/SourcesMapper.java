package com.ujiuye.prometion.mapper;

import com.ujiuye.prometion.pojo.Dept;
import com.ujiuye.prometion.pojo.Sources;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SourcesMapper {
    int save(Sources sources);
    int update(Sources sources);
    int remove(int id);
    List<Sources> list();
    Sources getById(int id);
}

package com.ujiuye.prometion.service;

import com.ujiuye.prometion.pojo.Sources;

import java.util.List;

public interface SourcesService {
    int save(Sources sources);
    int update(Sources sources);
    int remove(int id);
    List<Sources> list();
    Sources getById(int id);
}

package com.ujiuye.prometion.service;

import com.ujiuye.prometion.mapper.SourcesMapper;
import com.ujiuye.prometion.pojo.Sources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SourcesServiceImpl implements SourcesService {
    @Autowired
    private SourcesMapper sourcesMapper;
    @Override
    public int save(Sources sources) {
        return sourcesMapper.save(sources);
    }

    @Override
    public int update(Sources sources) {
        return sourcesMapper.update(sources);
    }

    @Override
    public int remove(int id) {
        return sourcesMapper.remove(id);
    }

    @Override
    public List<Sources> list() {
        return sourcesMapper.list();
    }

    @Override
    public Sources getById(int id) {
        return sourcesMapper.getById(id);
    }
}

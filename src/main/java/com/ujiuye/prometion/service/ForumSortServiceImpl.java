package com.ujiuye.prometion.service;

import com.ujiuye.prometion.mapper.ForumSortMapper;
import com.ujiuye.prometion.pojo.ForumSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ForumSortServiceImpl implements ForumSortService {
    @Autowired
    private ForumSortMapper forumSortMapper;

    @Override
    public List<ForumSort> list() {
        return forumSortMapper.selectByExample(null);
    }

}

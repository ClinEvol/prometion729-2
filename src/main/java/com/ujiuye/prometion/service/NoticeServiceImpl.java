package com.ujiuye.prometion.service;

import com.ujiuye.prometion.mapper.NoticeMapper;
import com.ujiuye.prometion.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public int save(Notice notice) {
        notice.setDate(new Date());
        return noticeMapper.insertSelective(notice);
    }

    @Override
    public List<Notice> list() {
        return noticeMapper.selectByExample(null);
    }

    @Override
    public Notice getById(int id) {
        return noticeMapper.selectByPrimaryKey(id);
    }
}

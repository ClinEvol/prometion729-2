package com.ujiuye.prometion.service;

import com.ujiuye.prometion.pojo.Notice;

import java.util.List;

public interface NoticeService {
    int save(Notice notice);
    List<Notice> list();
    Notice getById(int id);
}

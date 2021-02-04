package com.ujiuye.prometion.service;

import com.ujiuye.prometion.mapper.DeptMapper;
import com.ujiuye.prometion.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;


    @Override
    public int save(Dept dept) {
        return deptMapper.save(dept);
    }

    @Override
    public int update(Dept dept) {
        return deptMapper.update(dept);
    }

    @Override
    public int remove(int no) {
        return deptMapper.remove(no);
    }

    @Override
    public int removeList(List<Integer> nos) {
        return deptMapper.removeList(nos);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public Dept getByNo(int no) {
        return deptMapper.getByNo(no);
    }
}

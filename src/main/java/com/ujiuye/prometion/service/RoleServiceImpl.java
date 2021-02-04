package com.ujiuye.prometion.service;

import com.ujiuye.prometion.mapper.RoleMapper;
import com.ujiuye.prometion.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int save(Role role) {
        return roleMapper.save(role);
    }

    @Override
    public int update(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public int remove(int id) {
        return roleMapper.remove(id);
    }

    @Override
    public int removeList(List<Integer> ids) {
        return roleMapper.removeList(ids);
    }

    @Override
    public List<Role> list() {
        return roleMapper.list();
    }

    @Override
    public Role getById(int id) {
        return roleMapper.getById(id);
    }
}

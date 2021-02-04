package com.ujiuye.prometion.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.prometion.pojo.Role;

import com.ujiuye.prometion.pojo.Role;
import com.ujiuye.prometion.service.DeptService;
import com.ujiuye.prometion.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public PageInfo<Role> list(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
        PageHelper.startPage(pageNum,5);
        List<Role> list = roleService.list();
        PageInfo<Role> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
    @RequestMapping("/listAll")
    public List<Role> listAll(){
        List<Role> list = roleService.list();
        return list;
    }

    @RequestMapping("/getById")
    public Role getById(int id){
        return roleService.getById(id);
    }
    @RequestMapping("/save")
    public String save(Role role){
        try {
            roleService.save(role);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
    @RequestMapping("/update")
    public String update(Role role){
        try {
            roleService.update(role);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
    @RequestMapping("/remove")
    public String remove(int id){
        try {
            roleService.remove(id);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
    @RequestMapping("/removeList")
    public String removeList(Integer[] ids){//springmvc中可以接收数组，前台传参的格式  nos=1,2,3
        try {
            //把数据转成集合
            List<Integer> list = Arrays.asList(ids);
            roleService.removeList(list);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
}

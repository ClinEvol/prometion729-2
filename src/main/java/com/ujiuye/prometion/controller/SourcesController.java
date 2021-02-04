package com.ujiuye.prometion.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.prometion.pojo.Dept;
import com.ujiuye.prometion.pojo.Sources;
import com.ujiuye.prometion.service.DeptService;
import com.ujiuye.prometion.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sources")
public class SourcesController {
    @Autowired
    private SourcesService sourcesService;

    @RequestMapping("/listAll")
    public List<Sources> listAll(){
        List<Sources> list = sourcesService.list();
        return list;
    }

    @RequestMapping("/getById")
    public Sources getById(int id){
        return sourcesService.getById(id);
    }

    @RequestMapping("/save")
    public String save(Sources sources){
        try {
            sourcesService.save(sources);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
    @RequestMapping("/update")
    public String update(Sources sources){
        try {
            sourcesService.update(sources);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
    @RequestMapping("/remove")
    public String remove(int id){
        try {
            sourcesService.remove(id);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

}

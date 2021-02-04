package com.ujiuye.prometion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {

    @RequestMapping("/{page:.+}")       //index.html   404.html
    public String page(@PathVariable("page") String page){
        return page;
    }

}

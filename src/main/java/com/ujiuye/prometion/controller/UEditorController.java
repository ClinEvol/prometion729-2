package com.ujiuye.prometion.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

@Controller
public class UEditorController {
    private Logger logger = Logger.getLogger(UEditorController.class);

    /**
     * 初始化百度编辑器，可传入其他参数生成不同的编辑器,总入口
     *
     * @param response
     * @param request
     */
    @RequestMapping("/ueditor/init")
    public void initUeditor(HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("application/json");

        // 配置路径，首先获取static根目录绝对路径
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        // 将config.json放到与ueditor.config.js同一级的目录下。将ueditor所有文件放入到wapapp-ueditor下
        // 设置获取服务端配置文件地址修正路径，此路径同时作用于文件上传
        PrintWriter writer = null;
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            writer = response.getWriter();
            writer.write(exec);
            writer.flush();
        } catch (IOException e) {
            logger.error("百度编辑器初始化错误！", e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

}

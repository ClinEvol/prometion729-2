package com.ujiuye.prometion.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.prometion.pojo.Employee;
import com.ujiuye.prometion.pojo.Notice;
import com.ujiuye.prometion.service.NoticeService;
import com.ujiuye.prometion.utils.MyFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Value("${excel.url}")
    private String excelurl;

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(MultipartFile myfiles, String title, String editorValue, HttpSession session){
        Notice notice=new Notice();
        notice.setTitle(title);
        notice.setContent(editorValue);
        if(!myfiles.isEmpty()){//是否选择了附件
            File file =MyFileUtils.uploadFile(myfiles,excelurl);
            if(file==null){//上传失败
                return "error";
            }
            notice.setPath(file.getName());
        }
        //设置发布人   当前登录者
        Employee employee=(Employee)session.getAttribute("LOGIN_USER");
        notice.setCreateby(employee.getEid());

        try {
            noticeService.save(notice);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";

    }

    @RequestMapping("/list")
    @ResponseBody
    public PageInfo<Notice> list(int pageNum){
        PageHelper.startPage(pageNum,5);
        List<Notice> list = noticeService.list();
        PageInfo<Notice> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @RequestMapping("/getById")
    @ResponseBody
    public Notice getById(int id){
        return noticeService.getById(id);
    }

    //下载
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String filename){
        return MyFileUtils.download(filename,excelurl);
    }
}

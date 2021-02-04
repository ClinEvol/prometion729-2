package com.ujiuye.prometion.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件上传与下载的工具类
 */
public class MyFileUtils {


    /**
     * @param fileName 被下载的文件名称
     * @param path 被下载的文件路径，如果传null则使用默认路径C:/workplace/upload/
     * @return  ResponseEntity<byte[]>响应对应
     */
    public static ResponseEntity<byte[]> download(String fileName, String path){
        if(path==null){
            path="/Users/ClinEvol/Workspaces/upload/";//默认路径
        }
        File file=new File(path+fileName);//被下载的文件
        //创建响应头
        HttpHeaders headers=new HttpHeaders();
        //显示文件名编码
        String newName = null;
        try {
            newName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //设置浏览器的弹框
        headers.setContentDispositionFormData("attachment",newName);
        //设置文件类型  以流的方式下载
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        byte[] bytes = new byte[0];
        try {
            bytes = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResponseEntity<byte[]> responseEntity=new ResponseEntity<byte[]>(bytes,headers, HttpStatus.OK);
        return  responseEntity;
    }

    /**
     *
     * @param myfile  MultipartFile类型对象
     * @param path 上传文件路径，如果传null则使用默认路径C:/workplace/upload/
     * @return 上传成功则返回文件对象File，失败则反回null
     */
    public static File uploadFile(MultipartFile myfile, String path){
        if(path==null){
            path="/Users/ClinEvol/Workspaces/upload/";//默认路径
        }
        File file=null;
        if(myfile.getSize()>0){
            String fileName=myfile.getOriginalFilename();
            //重新设定文件名   后缀+时间+4随机数.后缀
            //txt202002121110323312321.txt
            //获取文件名后缀
            String suffixName=fileName.substring(fileName.lastIndexOf(".")+1);
            //获取当前时间
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String time=dateFormat.format(new Date());
            //生成4位随机数
            String number=String.valueOf(Math.random()).substring(3,7);
            //重新拼文件名
            fileName=suffixName+time+number+"."+suffixName;
            file=new File(path+fileName);
            try {
                myfile.transferTo(file);
                System.out.println("上传成功！");
            } catch (IOException e) {
                e.printStackTrace();
                file=null;
            }
        }
        return file;
    }

    /**
     *
     * @param myfiles  MultipartFile[]
     * @param path 上传文件路径，如果传null则使用默认路径C:/workplace/upload/
     * @return  List<File>成功list.size()>0,失败list.size()==0
     */
    public static List<File> uploadFileArray(MultipartFile[] myfiles, String path) {
        if(path==null){
            path="/Users/ClinEvol/Workspaces/upload/";//默认路径
        }
        List<File> list=new ArrayList<>();
        if(myfiles.length>0){
            for (MultipartFile myfile : myfiles) {
                if(myfile.getSize()>0){
                    String fileName=myfile.getOriginalFilename();
                    //重新设定文件名   后缀+时间+4随机数.后缀
                    //txt202002121110323312321.txt
                    //获取文件名后缀
                    String suffixName=fileName.substring(fileName.lastIndexOf(".")+1);
                    //获取当前时间
                    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
                    String time=dateFormat.format(new Date());
                    //生成4位随机数
                    String number=String.valueOf(Math.random()).substring(3,7);
                    //重新拼文件名
                    fileName=suffixName+time+number+"."+suffixName;
                    File file=new File(path+fileName);
                    try {
                        myfile.transferTo(file);
                        System.out.println("上传成功！");
                        list.add(file);//把上传成功的文件对象保存到集合中
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return list;
    }



    public static void deleteFile(String dir,String fileName){
        File file = new File(dir+fileName);
        boolean delete = file.delete();
        System.out.println(delete);
    }





}

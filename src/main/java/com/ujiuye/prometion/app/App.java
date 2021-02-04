package com.ujiuye.prometion.app;

import com.ujiuye.prometion.utils.MD5Utils;
import com.ujiuye.prometion.utils.PinyinHelperUtil;

import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        String password="java@#123456";
        String md5 = MD5Utils.stringToMD5(password);
        System.out.println(md5);




    }
}

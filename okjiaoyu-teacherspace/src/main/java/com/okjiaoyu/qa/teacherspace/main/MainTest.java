package com.okjiaoyu.qa.teacherspace.main;

import org.testng.TestNG;
/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-22:15:14
 * Modify date: 2018-11-22:15:14
 */
public class MainTest {
    /**
     * 项目编译后根目录
     */
    private static final String classPath = MainTest.class.getClassLoader().getResource("").getPath();

    public static void main(String[] args) {
        String loginPath = classPath+"/controller/login/login.xml";
        String[] arg0 = new String[]{loginPath};
        TestNG.privateMain(arg0,null);
    }
}

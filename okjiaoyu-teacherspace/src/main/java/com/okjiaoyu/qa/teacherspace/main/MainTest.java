package com.okjiaoyu.qa.teacherspace.main;

import org.testng.TestNG;
/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-22:15:14
 * Modify date: 2018-11-22:15:14
 */
public class MainTest {

    public static void main(String[] args) {
        String[] arg0 = new String[]{"/Users/liuzhanhui/workspace/okjiaoyu-monitor/okjiaoyu-teacherspace/target/classes/controller/login/login.xml"};
        TestNG.privateMain(arg0,null);
    }
}

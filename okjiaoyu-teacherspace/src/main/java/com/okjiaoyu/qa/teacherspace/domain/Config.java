package com.okjiaoyu.qa.teacherspace.domain;
import com.okjiaoyu.qa.util.PropertiesUtil;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-23:10:07
 * Modify date: 2018-11-23:10:07
 */
public interface Config {

    public static final String URL = PropertiesUtil.getProperty("url");

    public static final String CHROME_PATH = PropertiesUtil.getProperty("chromePath");

    public static final String PACKAGE_NAME = PropertiesUtil.getProperty("packageName");

    public static final String ACCOUNT = PropertiesUtil.getProperty("account");

    public static final String PASSWORD = PropertiesUtil.getProperty("password");
}

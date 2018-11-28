package com.okjiaoyu.qa.teacherspace.driver;

import com.okjiaoyu.qa.util.service.IDriver;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-20:11:08
 * Modify date: 2018-11-20:11:08
 */
public interface IWebDriver<T> extends IDriver {

    T chromeDriver();

    T fireFoxDriver();

    T ieDriver();

    T safairDriver();
}

package com.okjiaoyu.qa.teacherspace.driver;
import com.okjiaoyu.qa.teacherspace.domain.Config;
import com.okjiaoyu.qa.util.service.DriverProvider;

/**
 * @Author: liuzhanhui
 * @Decription: web服务接口
 * @Date: Created in 2018-11-20:09:59
 * Modify date: 2018-11-20:09:59
 */
public class WebDriverFactory implements DriverProvider<WebDriverManager> {

    public WebDriverManager factory() {
        String chromePath = Config.CHROME_PATH;
        return new WebDriverManager.Builder().chromePath(chromePath).build();
    }
}

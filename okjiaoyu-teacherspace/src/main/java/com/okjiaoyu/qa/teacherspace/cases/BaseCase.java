package com.okjiaoyu.qa.teacherspace.cases;

import com.okjiaoyu.qa.teacherspace.BaseOperate;
import com.okjiaoyu.qa.teacherspace.domain.Config;
import com.okjiaoyu.qa.teacherspace.driver.WebDriverFactory;
import com.okjiaoyu.qa.teacherspace.driver.WebDriverManager;
import com.okjiaoyu.qa.util.service.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-22:09:59
 * Modify date: 2018-11-22:09:59
 */
public class BaseCase {

    WebDriver driver = null;

    @BeforeSuite
    public void initHelper(){
        DriverProvider<WebDriverManager> webdriver = new WebDriverFactory();
        driver = webdriver.factory().chromeDriver();
        BaseOperate.driver = driver;
        driver.get(Config.URL);
    }

    @AfterSuite(alwaysRun = true)
    public void close(){
        driver.quit();
    }
}

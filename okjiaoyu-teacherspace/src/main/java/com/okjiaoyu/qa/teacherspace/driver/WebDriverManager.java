package com.okjiaoyu.qa.teacherspace.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-20:09:55
 * Modify date: 2018-11-20:09:55
 */
public class WebDriverManager implements IWebDriver<WebDriver> {

    private final String chromePath;

    private final String firefoxPath;

    public WebDriver chromeDriver() {
        if (chromePath != null || "".equals(chromePath)){
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromePath);
        }
        return new ChromeDriver();
    }

    public WebDriver fireFoxDriver() {
        return null;
    }

    public WebDriver ieDriver() {
        return null;
    }

    public WebDriver safairDriver() {
        return null;
    }

    public Object driver() {
        return new HtmlUnitDriver();
    }

    public static class Builder{
        private String chromePath;

        private String firefoxPath;

        public Builder chromePath(String chromePath){
            this.chromePath = chromePath;
            return this;
        }

        public Builder firefoxPath(String firefoxPath){
            this.firefoxPath = firefoxPath;
            return this;
        }

        public WebDriverManager build(){
            return new WebDriverManager(this);
        }
    }

    private WebDriverManager(Builder builder){
        this.chromePath = builder.chromePath;
        this.firefoxPath = builder.firefoxPath;
    }
}

package com.okjiaoyu.qa.util.service;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-20:10:01
 * Modify date: 2018-11-20:10:01
 */
public class AndroidDriverFactory implements DriverProvider<AndroidDriverManager> {

    public AndroidDriverManager factory() {
        AndroidDriverManager androidDriverManager = new AndroidDriverManager.Builder().
                host("").port(0).capabilities(capabilities()).build();
        return androidDriverManager;
    }

    private DesiredCapabilities capabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","");
        capabilities.setCapability("deviceName", "");
        //设置android系统版本
        capabilities.setCapability("platformVersion","");
        capabilities.setCapability("unicodeKeyboard","");
        //重置输入法为系统默认
        capabilities.setCapability("resetKeyboard","");
        //no need sign 安装时不对apk进行重签名，设置很有必要，否则有的apk在重签名之后无法正常使用
        capabilities.setCapability("noSign","");
        capabilities.setCapability("noReset","");

        //设置app的主包名和主类名
        capabilities.setCapability("appPackage","");
        capabilities.setCapability("appActivity","");
        capabilities.setCapability("automationName", "uiautomator2");
        return capabilities;
    }
}

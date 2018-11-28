package com.okjiaoyu.qa.util.service;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-20:09:56
 * Modify date: 2018-11-20:09:56
 */
public class AndroidDriverManager implements IDriver<AndroidDriver> {

    private final String host;
    private final int port;
    private final DesiredCapabilities capabilities;

    public AndroidDriver driver() {
        URL url = null;
        try {
            url = new URL("http://"+host+":"+port+"/hub/wd");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new AndroidDriver(url, capabilities);
    }

    public static class Builder{
        private String host = "127.0.0.1";
        private int port = 4723;
        private DesiredCapabilities capabilities;

        public Builder host(String host){
            this.host = host;
            return this;
        }

        public Builder port(int port){
            this.port = port;
            return this;
        }

        public Builder capabilities(DesiredCapabilities capabilities){
            this.capabilities = capabilities;
            return this;
        }

        public AndroidDriverManager build(){
            return new AndroidDriverManager(this);
        }

    }

    private AndroidDriverManager(Builder builder){
        this.host = builder.host;
        this.port = builder.port;
        this.capabilities = builder.capabilities;
    }
}

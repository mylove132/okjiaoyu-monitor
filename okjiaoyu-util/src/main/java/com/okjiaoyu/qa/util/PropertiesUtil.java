package com.okjiaoyu.qa.util;
import java.io.*;
import java.util.Properties;

public class PropertiesUtil implements Serializable {

    private static Properties props;
    static{
        loadProps();
    }

    synchronized static private void loadProps(){
        props = new Properties();
        InputStream in = null;
        try {
            //第一种，通过类加载器进行获取properties文件流
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
            //第二种，通过类进行获取properties文件流
            //in = PropertiesUtil.class.getResourceAsStream("/config.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }


}

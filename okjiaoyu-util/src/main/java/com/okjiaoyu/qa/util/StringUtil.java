package com.okjiaoyu.qa.util;

/**
 * @Author: liuzhanhui
 * @Decription: 字符串工具类
 * @Date: Created in 2018-11-19:15:23
 * Modify date: 2018-11-19:15:23
 */
public final class StringUtil {

    public static Boolean isEmpty(String str){
        if (str == null || "".equals(str)){
            return true;
        }
        return false;
    }

    public static Boolean isNoEmpty(String str){
       return !isEmpty(str);
    }

    public static String strToUpperCase(String str) throws Exception {
        if (isEmpty(str)){
            throw new Exception("字符串不能为空");
        }
        return str.toUpperCase();
    }

    public static String strToLowerCase(String str) throws Exception {
        if (isEmpty(str)){
            throw new Exception("字符串不能为空");
        }
        return str.toLowerCase();
    }
}

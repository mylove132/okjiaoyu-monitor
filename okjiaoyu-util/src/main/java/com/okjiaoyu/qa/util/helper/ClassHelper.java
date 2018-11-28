package com.okjiaoyu.qa.util.helper;

import com.okjiaoyu.qa.util.ClassUtil;
import com.okjiaoyu.qa.util.PropertiesUtil;
import com.okjiaoyu.qa.util.annotation.Page;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: liuzhanhui
 * @Decription: 类加载助手
 * @Date: Created in 2018-11-20:16:39
 * Modify date: 2018-11-20:16:39
 */
public final class ClassHelper {

    public static List<Class<?>> pageListClass(){
        String packageName = PropertiesUtil.getProperty("packageName");
        Set<Class<?>> CLASS_LIST = ClassUtil.getClzFromPkg(packageName);
        List<Class<?>> pageListClasses = new ArrayList<Class<?>>();
        if (!CLASS_LIST.isEmpty()){
            for (Class<?> clazz : CLASS_LIST){
                if (clazz.getAnnotation(Page.class) != null){
                    pageListClasses.add(clazz);
                }
            }
        }
        return pageListClasses;
    }

    public static void main(String[] args) {
        System.out.println(PropertiesUtil.getProperty("packageName"));
    }
}

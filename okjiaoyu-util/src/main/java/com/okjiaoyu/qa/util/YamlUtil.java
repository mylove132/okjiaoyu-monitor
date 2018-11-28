package com.okjiaoyu.qa.util;
import com.okjiaoyu.qa.util.entity.ElementEntity;
import org.apache.commons.beanutils.BeanUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-21:14:25
 * Modify date: 2018-11-21:14:25
 */
public class YamlUtil {

    public static List<ElementEntity> pageElement(InputStream yamlInputstream){
        List<ElementEntity> elementEntities = new ArrayList<ElementEntity>();
        Yaml yaml = new Yaml();
        List<Map<String, Object>> mapList = yaml.load(yamlInputstream);
        for (Map<String, Object> map :mapList){
            ElementEntity elementEntity = null;
            try {
                elementEntity = ElementEntity.class.newInstance();
                BeanUtils.populate(elementEntity, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            elementEntities.add(elementEntity);
        }
        return elementEntities;
    }
}

package com.okjiaoyu.qa.teacherspace;

import com.okjiaoyu.qa.util.YamlUtil;
import com.okjiaoyu.qa.util.annotation.Page;
import com.okjiaoyu.qa.util.entity.ElementEntity;
import com.okjiaoyu.qa.util.helper.ClassHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuzhanhui
 * @Decription: 页面操作基类
 * @Date: Created in 2018-11-20:14:56
 * Modify date: 2018-11-20:14:56
 */
public class BaseOperate {

    /**
     * 方法名--->元素实体映射
     */
    public final Map<String, ElementEntity> ELEMENT_ENTITY_MAP = loadAllPages();
    protected static final Logger LOG = Logger.getLogger(BaseOperate.class);
    public static WebDriver driver;


    /**
     * 加载所有页面的元素实体
     *
     * @return
     */
    private static Map<String, ElementEntity> loadAllPages() {
        Map<String, ElementEntity> elementEntityMap = new HashMap<>();
        List<Class<?>> pageList = ClassHelper.pageListClass();
        for (Class<?> clazz : pageList) {
            String className = clazz.getCanonicalName();
            String classPath = ("page" + className.split("page")[1]).split(clazz.getSimpleName())[0].replace(".", "/");
            Page page = clazz.getAnnotation(Page.class);
            String pageName = page.page();
            BaseOperate.class.getClassLoader().getResourceAsStream(classPath + pageName + ".yaml").toString();
            InputStream yamlInputstream = BaseOperate.class.getClassLoader().getResourceAsStream(classPath + pageName + ".yaml");
            List<ElementEntity> elementEntities = YamlUtil.pageElement(yamlInputstream);
            for (ElementEntity entity : elementEntities) {
                elementEntityMap.put(entity.getName(), entity);
            }
        }
        return elementEntityMap;
    }

    /**
     * 通过方法名反射获取实体
     *
     * @return
     */
    protected ElementEntity getElementEntity() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];
        String methodName = e.getMethodName();
        ElementEntity entity = ELEMENT_ENTITY_MAP.get(methodName);

        return entity;
    }

    private static WebElement waitforElement(ElementEntity elementEntity) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(elementEntity.getTimeOut()));

            webElement = wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(WebDriver webDriver) {
                    WebElement element = null;
                    switch (elementEntity.getType()){
                        case "XPATH":
                            element = webDriver.findElement(By.xpath(elementEntity.getLocation()));
                            break;
                        case "ID":
                            element = webDriver.findElement(By.id(elementEntity.getLocation()));
                            break;
                        case "NAME":
                            element = webDriver.findElement(By.name(elementEntity.getLocation()));
                            break;
                        case "CLASSNAME":
                            element = webDriver.findElement(By.className(elementEntity.getLocation()));
                            break;
                        case "CSS":
                            element = webDriver.findElement(By.cssSelector(elementEntity.getLocation()));
                            break;
                        case "LINKTEXT":
                            element = webDriver.findElement(By.linkText(elementEntity.getLocation()));
                            break;
                        case "PARTIALLINKTEXT":
                            element = webDriver.findElement(By.partialLinkText(elementEntity.getLocation()));
                            break;
                        case "TAGNAME":
                            element = webDriver.findElement(By.tagName(elementEntity.getLocation()));
                            break;
                    }
                    return element;
                }
            });
        }catch (TimeoutException e){
            LOG.error(elementEntity.getDescription()+"元素加载超时:"+elementEntity.toString());
            throw new TimeoutException(e);
        }catch (Exception e){
            LOG.error(elementEntity.getDescription()+"元素加载失败:"+elementEntity.toString());
            throw new RuntimeException(e);
        }
        return webElement;
    }

    protected void setValue(ElementEntity elementEntity, String value){
        waitforElement(elementEntity).sendKeys(value);
        LOG.info(elementEntity.getDescription()+"输入内容："+value);
    }

    protected void click(ElementEntity elementEntity){
        waitforElement(elementEntity).click();
        LOG.info(elementEntity.getDescription()+"点击");
    }

    /**
     * 判断元素是否出现
     * @return
     */
    protected boolean isPrentElement(ElementEntity elementEntity){
        if (waitforElement(elementEntity) == null){
            return false;
        }
        return true;
    }

}

package com.okjiaoyu.qa.dubbo;

import com.noriental.lessonsvr.entity.request.LongRequest;
import com.noriental.lessonsvr.entity.vo.LinkPublishResource;
import com.noriental.lessonsvr.rservice.LessonService;
import com.noriental.validate.bean.CommonResponse;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-23:17:36
 * Modify date: 2018-11-23:17:36
 */
public class DubboCase {
    @Resource
    LessonService lessonService;

    LongRequest request = new LongRequest();
    CommonResponse<List<LinkPublishResource>> response;

    @Test
    public void runTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo.xml");
        lessonService = (LessonService)context.getBean("LessonService");
        request.setReqId("2131299312");
        request.setId(001);
        response = lessonService.fetchResourceByPublishId(request);
        System.out.println(response);
    }
}

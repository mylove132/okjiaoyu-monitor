package com.okjiaoyu.qa.dubbo;

        import com.noriental.lessonsvr.entity.request.TeacherResourceRequest;
        import com.noriental.lessonsvr.rservice.LessonService;
        import org.joda.time.DateTime;
        import org.junit.Before;
        import org.junit.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

/**
 * Created by Administrator on 2016/9/2.
 */
public class TqueryTakeRegNo {

    /*
     *定义DirectRegisterInfoInf的变量
     */
    @Autowired
    private LessonService lessonService;

    /*
     *初始化directRegisterInfoService服务
     */
    @Before
    public void setupTest() {
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:dubbo.xml");
        lessonService = (LessonService)applicationContext.getBean("lessonService");
    }

    /*
     *测试代码
     */
    @Test
    public void runTest() {
        System.out.println(lessonService);
        TeacherResourceRequest resourceRequest = new TeacherResourceRequest();
        //lessonService.deleleLesson(resourceRequest);
    }

}

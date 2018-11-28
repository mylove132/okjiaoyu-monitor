package com.okjiaoyu.qa.dubbo;

import com.noriental.lessonsvr.rservice.LessonService;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author: wangsaichao
 * @date: 2017/12/22
 * @description:
 */
public class DubboTest extends AbstractJavaSamplerClient {


    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        return null;
    }
}

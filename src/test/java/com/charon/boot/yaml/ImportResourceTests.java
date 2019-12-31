package com.charon.boot.yaml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: 加载xml文件配置
 * @author: charon
 * @create: 2019-12-31 17:50
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportResourceTests {
    @Autowired
    private ConfigurableApplicationContext ioc;

    @Test
    public void testHelloService() {
        // 测试Spring上下文环境中是否有testBeanService这样一个bean，有的话表示xml配置文件生效
        boolean testBeanService= ioc.containsBean("testBeanService");
        System.out.println(testBeanService);
    }
}

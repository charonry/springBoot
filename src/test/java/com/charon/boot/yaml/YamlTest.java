package com.charon.boot.yaml;

import com.charon.boot.entity.yaml.Family;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: yaml两种获取自定义配置的方式
 * @author: charon
 * @create: 2019-12-30 22:43
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class YamlTest {

    @Autowired
    Family family;

    @Test
    public void hello(){
        System.out.println(family.toString());
    }
}

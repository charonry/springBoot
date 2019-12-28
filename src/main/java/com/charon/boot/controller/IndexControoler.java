package com.charon.boot.controller;

import com.charon.boot.entity.Article;
import com.charon.boot.entity.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-28 15:45
 **/
@Slf4j
@RestController
public class IndexControoler {

    /**
     * 对于lombok插件的使用
     *
     * @return
     */
    @RequestMapping("/hello")
    public Article hello() {
        Article article = new Article(1L,"charon","boot","2.o"
                ,new Date(), new ArrayList<Reader>());
        Article articleBuilder = Article.builder().id(2l).build();
        log.info("创建Article{}",articleBuilder);
        return article;
    }
}

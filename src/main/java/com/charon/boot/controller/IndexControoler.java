package com.charon.boot.controller;

import com.charon.boot.entity.ArticleVO;
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
    public ArticleVO hello() {
        ArticleVO articleVO = new ArticleVO(1L,"charon","boot","2.o"
                ,new Date(), new ArrayList<Reader>());
        ArticleVO articleVOBuilder = ArticleVO.builder().id(2l).build();
        log.info("创建Article{}", articleVOBuilder);
        return articleVO;
    }
}

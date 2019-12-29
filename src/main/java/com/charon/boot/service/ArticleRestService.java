package com.charon.boot.service;

import com.charon.boot.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-29 20:42
 **/
@Slf4j
@Service
public class ArticleRestService {

    public String saveArticle( Article article) {
        log.info("saveArticle：{}",article);
        return  "保存作者信息";
    }
}

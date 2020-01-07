package com.charon.boot.dao;

import com.charon.boot.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-07 18:43
 **/
public interface ArticleDao extends MongoRepository<Article,String> {
    Article findByAuthor(String author);
}

package com.charon.boot.dao;

import com.charon.boot.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-07 18:43
 **/
@RepositoryRestResource(collectionResourceRel = "article",path="rest/article")
public interface ArticleDao extends MongoRepository<Article,String> {
    Article findByAuthor(String author);
}

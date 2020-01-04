package com.charon.boot.dao;

import com.charon.boot.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-04 16:05
 **/
public interface ArticleRepository extends JpaRepository<Article,Long> {

    // jPA会根据方法名自动生成SQL执行
    Article findByAuthor(String author);
}

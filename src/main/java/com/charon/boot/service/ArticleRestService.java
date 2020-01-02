package com.charon.boot.service;

import com.charon.boot.entity.Article;

import java.util.List;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-02 22:45
 **/
public interface ArticleRestService {

    public Article saveArticle(Article article);

    public void deleteArticle(Long id);

    public void updateArticle(Article article);

    public Article getArticle(Long id);

    public List<Article> getAll();
}

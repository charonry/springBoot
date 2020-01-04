package com.charon.boot.service;

import com.charon.boot.entity.ArticleVO;

import java.util.List;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-04 16:10
 **/
public interface ArticleRestService {
    ArticleVO saveArticle(ArticleVO article);

    void deleteArticle(Long id);

    void updateArticle(ArticleVO article);

    ArticleVO getArticle(Long id);

    List<ArticleVO> getAll();
}

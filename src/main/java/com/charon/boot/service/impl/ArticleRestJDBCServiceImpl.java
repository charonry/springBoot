package com.charon.boot.service.impl;

import com.charon.boot.dao.ArticleJDBCDao;
import com.charon.boot.entity.Article;
import com.charon.boot.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-29 20:42
 **/
@Slf4j
@Service
public class ArticleRestJDBCServiceImpl implements ArticleRestService {

    @Resource
    private

    ArticleJDBCDao articleJDBCDao;

    @Transactional
    @Override
    public Article saveArticle( Article article) {
        articleJDBCDao.save(article);
        // 人为制造一个异常，用于测试事务
        // int a = 2/0；
        return article;
    }

    @Override
    public void deleteArticle(Long id){
        articleJDBCDao.deleteById(id);
    }

    @Override
    public void updateArticle(Article article){
        articleJDBCDao.updateById(article);
    }

    @Override
    public Article getArticle(Long id){
        return articleJDBCDao.findById(id);
    }

    @Override
    public List<Article> getAll(){
        return articleJDBCDao.findAll();
    }
}

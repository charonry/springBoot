package com.charon.boot.service.impl;

import com.charon.boot.dao.ArticleJDBCDao;
import com.charon.boot.entity.Article;
import com.charon.boot.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
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
    ArticleJDBCDao articleJDBCDao;

    @Resource
    JdbcTemplate primaryJdbcTemplate;

    @Resource
    JdbcTemplate secondaryJdbcTemplate;


    @Transactional
    @Override
    public Article saveArticle( Article article) {
        articleJDBCDao.save(article,primaryJdbcTemplate);

        articleJDBCDao.save(article,secondaryJdbcTemplate);
        // 人为制造一个异常，用于测试事务
        // int a = 2/0；
        return article;
    }

    @Override
    public void deleteArticle(Long id){
        articleJDBCDao.deleteById(id,primaryJdbcTemplate);
    }

    @Override
    public void updateArticle(Article article){
        articleJDBCDao.updateById(article,primaryJdbcTemplate);
    }

    @Override
    public Article getArticle(Long id){
        return articleJDBCDao.findById(id,primaryJdbcTemplate);
    }

    @Override
    public List<Article> getAll(){
        return articleJDBCDao.findAll(primaryJdbcTemplate);
    }
}

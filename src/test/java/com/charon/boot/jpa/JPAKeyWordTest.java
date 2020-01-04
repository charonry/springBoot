package com.charon.boot.jpa;

import com.charon.boot.dao.ArticleRepository;
import com.charon.boot.model.Article;
import com.charon.boot.utils.DynamicJPAUtils;
import org.hibernate.annotations.DynamicUpdate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @description: 对于find关键字进行测试
 * @author: charon
 * @create: 2020-01-04 17:39
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {


    @Resource
    private ArticleRepository articleRepository;

    @Test
    public void userTest() {
        Article article = articleRepository.findByAuthor("charon");
        System.out.println(article);
    }

    @Test
    public void pageTest(){
        Pageable pageable = PageRequest.of(1, 3
                , Sort.by("id").ascending().and(Sort.by("createTime").descending()));
        Page<Article> articlePage = articleRepository.findAll(pageable);
        List<Article> articleList = articlePage.getContent();
        System.out.println(articleList);
        Page<Article> byAuthor = articleRepository.findByAuthor("ss", pageable);
        Slice<Article> byAuthorAndTitle = articleRepository.findByAuthorAndTitle("s", "s", pageable);
    }

    @Test
    public void dynamicJPA(){
        Article dynamicArticle =new Article();
        dynamicArticle.setId(15L);
        dynamicArticle.setAuthor("chacane");
        dynamicArticle.setTitle("dynamicJPA");
        Optional<Article> optionalArticle = articleRepository.findById(15L);
        Article article = optionalArticle.get();
        BeanUtils.copyProperties(dynamicArticle,article, DynamicJPAUtils.getNullPropertyNames(dynamicArticle));
        articleRepository.save(article);
    }
}

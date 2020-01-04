package com.charon.boot.jpa;

import com.charon.boot.dao.ArticleRepository;
import com.charon.boot.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
}

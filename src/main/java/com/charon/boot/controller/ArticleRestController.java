package com.charon.boot.controller;

import com.charon.boot.entity.AjaxResponse;
import com.charon.boot.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @description: 常用注解开发一个RESTful接口
 * @author: charon
 * @create: 2019-12-28 17:07
 **/
@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    /**
     *  增加一篇Article ，使用POST方法
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        // 因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle：{}",article);
        return  AjaxResponse.success(article);
    }

    /**
     * 删除一篇Article，使用DELETE方法，参数是id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        log.info("deleteArticle：{}",id);
        return AjaxResponse.success(id);
    }


    /**
     * 更新一篇Article，使用PUT方法，以id为主键进行更新
     *
     * @param id
     * @param article
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        log.info("updateArticle：{}",article);
        return AjaxResponse.success(article);
    }

    /**
     * 获取一篇Article，使用GET方法
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {

        // 使用lombok提供的builder构建对象
        Article article1 = Article.builder()
                .id(1L)
                .author("charon")
                .content("spring boot")
                .createTime(new Date())
                .title("title").build();
        return AjaxResponse.success(article1);
    }
}
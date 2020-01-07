package com.charon.boot.controller;

import com.charon.boot.dao.ArticleDao;
import com.charon.boot.entity.AjaxResponse;
import com.charon.boot.entity.Article;
import com.charon.boot.service.ArticleRestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private ArticleRestService articleRestService;

    @Resource
    MongoRepository mongoRepository;

    @Resource
    ArticleDao articleDao;

    @Resource
    MongoTemplate mongoTemplate;

    /**
     *  增加一篇Article ，使用POST方法
     *
     * @param article
     * @return
     */
    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=AjaxResponse.class),
            @ApiResponse(code=400,message="用户输入错误",response=AjaxResponse.class),
            @ApiResponse(code=500,message="系统内部错误",response=AjaxResponse.class)
    })
    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        mongoRepository.save(article);
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
        mongoRepository.deleteById(id);
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
        mongoRepository.save(article);
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
        // Optional<Article> optional = mongoRepository.findById(id);
        // Article article  = optional.get();
        // Article article = articleDao.findByAuthor("charon");
        Query query = new Query(Criteria.where("author").is("charon"));
        List<Article> articles = mongoTemplate.find(query, Article.class);
        return AjaxResponse.success(articles.get(0));
    }

    @GetMapping( "/article")
    public @ResponseBody  AjaxResponse getAll() {
        return AjaxResponse.success(articleDao.findAll());
    }

}

package com.charon.boot.controller;

import com.charon.boot.entity.AjaxResponse;
import com.charon.boot.entity.ArticleVO;
import com.charon.boot.service.ArticleRestService;
import com.charon.boot.service.impl.ArticleRestServiceJPAImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource(name = "articleRestServiceJPAImpl")
    private ArticleRestService articleRestServiceJPAImpl;

    /**
     *  增加一篇Article ，使用POST方法
     *
     * @param articleVO
     * @return
     */
    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "ArticleVO",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=AjaxResponse.class),
            @ApiResponse(code=400,message="用户输入错误",response=AjaxResponse.class),
            @ApiResponse(code=500,message="系统内部错误",response=AjaxResponse.class)
    })
    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody ArticleVO articleVO) {
        // 因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle：{}", articleVO);
        log.info("articleRestService return :" + articleRestServiceJPAImpl.saveArticle(articleVO));
        return  AjaxResponse.success(articleVO);
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
        articleRestServiceJPAImpl.deleteArticle(id);
        return AjaxResponse.success(id);
    }


    /**
     * 更新一篇Article，使用PUT方法，以id为主键进行更新
     *
     * @param id
     * @param articleVO
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO articleVO) {
        articleVO.setId(id);
        log.info("updateArticle：{}", articleVO);
        articleRestServiceJPAImpl.updateArticle(articleVO);
        return AjaxResponse.success(articleVO);
    }

    /**
     * 获取一篇Article，使用GET方法
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {
        return AjaxResponse.success(articleRestServiceJPAImpl.getArticle(id));
    }

    @GetMapping( "/article")
    public @ResponseBody  AjaxResponse getAll() {
        return AjaxResponse.success(articleRestServiceJPAImpl.getAll());
    }
}

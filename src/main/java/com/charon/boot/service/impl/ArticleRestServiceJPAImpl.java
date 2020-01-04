package com.charon.boot.service.impl;

import com.charon.boot.dao.ArticleRepository;
import com.charon.boot.entity.ArticleVO;
import com.charon.boot.model.Article;
import com.charon.boot.service.ArticleRestService;
import com.charon.boot.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-29 20:42
 **/
@Slf4j
@Service
public class ArticleRestServiceJPAImpl implements ArticleRestService {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    @Override
    public ArticleVO saveArticle(ArticleVO articleVO) {
        Article articlePO = dozerMapper.map(articleVO, Article.class);
        articleRepository.save(articlePO);
        return  articleVO;
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleVO articleVO) {
        Article articlePO = dozerMapper.map(articleVO,Article.class);
        articleRepository.save(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        // 把读者查出来
        ArticleVO articleVO = dozerMapper.map(article.get(),ArticleVO.class);
        // articleVO.setReader();
        return articleVO;
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articleList = articleRepository.findAll();
        return DozerUtils.mapList(articleList,ArticleVO.class);
    }
}

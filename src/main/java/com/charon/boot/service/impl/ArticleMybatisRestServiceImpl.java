package com.charon.boot.service.impl;

import com.charon.boot.dao.bootmybatis.ArticleMapper;
import com.charon.boot.dao.bootmybatis2.MessageDao;
import com.charon.boot.entity.ArticleVO;
import com.charon.boot.model.bootmybatis.Article;
import com.charon.boot.model.bootmybatis2.Message;
import com.charon.boot.service.ArticleRestService;
import com.charon.boot.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService {

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private MessageDao messageDao;

    @Override
    @Transactional
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.insert(articlePO);
        Message message = new Message();
        message.setName("erre");
        message.setContent("erre");
        messageDao.insert(message);
        return null;
    }

    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);

    }
}

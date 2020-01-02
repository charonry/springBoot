package com.charon.boot.dao;

import com.charon.boot.entity.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-02 22:39
 **/
@Repository
public class ArticleJDBCDao {

    // jdbcTemplate.update适合于insert 、update和delete操作；
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 保存文章
     *
     * @param article
     */
    public void save(Article article) {
        jdbcTemplate.update("INSERT INTO article(author, title,content,create_time) values(?, ?, ?, ?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());

    }

    /**
     * 删除文章
     *
     * @param id
     */
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM article WHERE id = ?",new Object[]{id});

    }



    /**
     * 更新文章
     *
     * @param article
     */
    public void updateById(Article article) {
        jdbcTemplate.update("UPDATE article SET author = ?, title = ? ,content = ?,create_time = ? WHERE id = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());

    }

    /**
     * 根据id查找文章
     *
     * @param id
     * @return
     */
    public Article findById(Long id) {
        // queryForObject用于查询单条记录返回结果
        return (Article) jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper(Article.class));
    }



    /**
     * 查询所有
     *
     * @return
     */
    public List<Article> findAll(){
        return (List<Article>) jdbcTemplate.query("SELECT * FROM article ",  new BeanPropertyRowMapper(Article.class));
    }
}

package com.charon.boot.JDBCDataSources;

import com.charon.boot.dao.ArticleJDBCDao;
import com.charon.boot.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-02 23:42
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class JDBCDataSourcesTest {

    @Resource
    private ArticleJDBCDao articleJDBCDao;
    @Resource
    private JdbcTemplate primaryJdbcTemplate;
    @Resource
    private JdbcTemplate secondaryJdbcTemplate;


    @Test
    public void testJdbc() {
        articleJDBCDao.save(
                Article.builder()
                        .author("charon").title("primaryJdbcTemplate").content("ceshi").createTime(new Date())
                        .build(),
                primaryJdbcTemplate);
        articleJDBCDao.save(
                Article.builder()
                        .author("charon").title("secondaryJdbcTemplate").content("ceshi").createTime(new Date())
                        .build(),
                secondaryJdbcTemplate);
    }
}

package com.charon.boot.dao;

import com.charon.boot.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-04 16:05
 **/
public interface ArticleRepository extends JpaRepository<Article,Long> , PagingAndSortingRepository<Article,Long> {

    // jPA会根据方法名自动生成SQL执行
    Article findByAuthor(String author);

    // 查询article表的所有数据，传入Pageable分页参数
    Page<Article> findAll(Pageable pageable);
    //根据author字段查询article表数据，传入Pageable分页参数
    Page<Article> findByAuthor(String author, Pageable pageable);
    //根据author字段和title字段，查询article表数据，传入Pageable分页参数
    Slice<Article> findByAuthorAndTitle(String author, String title, Pageable pageable);
}

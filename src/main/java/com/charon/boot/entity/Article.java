package com.charon.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * @description: lombok插件
 * @author: charon
 * @create: 2019-12-28 16:00
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {

    private Long id;
    private String author;
    private String title;
    private String content;
    private String createTime;
    private List<ReaderBean> reader;

}

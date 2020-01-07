package com.charon.boot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @description: lombok插件
 * @author: charon
 * @create: 2019-12-28 16:00
 **/
@Document(collection = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article implements Serializable {

    private static final long serialVersionUID = -1928222831836337996L;

    @Id
    private Long id;
    //索引
    @Indexed
    private String author;

    private String title;
    // 别名
    //@Field("msgContent")
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreatedDate
    private Date createTime;

    private List<Reader> reader;

}

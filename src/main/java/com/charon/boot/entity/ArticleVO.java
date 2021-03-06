package com.charon.boot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
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
public class ArticleVO implements Serializable {

    private static final long serialVersionUID = -1928222831836337996L;

    private Long id;
    private String author;
    private String title;
    @NotEmpty(message = "文章内容不能为空，请检查您的输入")
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private List<Reader> reader;

}

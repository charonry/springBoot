package com.charon.boot.entity.yaml;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-30 22:35
 **/
@Data
public class Child {

    private String name;

    private Integer age;

    private List<Friend> friends;
}

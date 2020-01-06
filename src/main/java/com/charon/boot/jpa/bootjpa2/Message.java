package com.charon.boot.jpa.bootjpa2;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-06 15:34
 **/
@Data
@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;
}

package com.charon.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-28 16:00
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader implements Serializable {
    private static final long serialVersionUID = -5287722752020518762L;
    private String name;
    private int age;

}

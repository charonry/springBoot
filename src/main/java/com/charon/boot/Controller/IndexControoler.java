package com.charon.boot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-28 15:45
 **/
@RestController
public class IndexControoler {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }
}

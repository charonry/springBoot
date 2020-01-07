package com.charon.boot.controller;

import com.charon.boot.entity.ArticleVO;
import com.charon.boot.service.ArticleRestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:  对于jsp处理
 * @author: charon
 * @create: 2020-01-07 23:04
 **/
@Controller
@RequestMapping("/template")
public class TemplateController {

    @Resource(name="articleMybatisRestServiceImpl")
    ArticleRestService articleRestService;

    @GetMapping("/jsp")
    public String index(String name, Model model) {
        List<ArticleVO> articles = articleRestService.getAll();
        model.addAttribute("articles", articles);
        // 模版名称，实际的目录为：src/main/webapp/WEB-INF/jsp/jsptemp.jsp
        return "jsptemp";
    }
}

package com.charon.boot.controller;

import com.charon.boot.entity.ArticleVO;
import com.charon.boot.exception.ModelView;
import com.charon.boot.service.ArticleRestService;
import com.charon.boot.service.ExceptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: charon
 * @create: 2020-01-08 20:26
 **/
@Controller
@RequestMapping("/template")
public class TemplateController {

    @Resource(name="articleMybatisRestServiceImpl")
    ArticleRestService articleRestService;

    @Resource
    ExceptionService exceptionService;

    @ModelView
    @GetMapping("/freemarker")
    public String index(Model model) {
        List<ArticleVO> articles = articleRestService.getAll();
        model.addAttribute("articles", articles);
        exceptionService.systemBizError();
        // 模版名称，实际的目录为：resources/templates/fremarkertemp.html
        return "fremarkertemp";
    }
}

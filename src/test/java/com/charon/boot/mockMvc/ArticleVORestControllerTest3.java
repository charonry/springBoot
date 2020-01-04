package com.charon.boot.mockMvc;

import com.charon.boot.controller.ArticleRestController;
import com.charon.boot.entity.ArticleVO;
import com.charon.boot.service.impl.ArticleRestServiceJPAImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @description: 测试Mockito,加上作用返回和自动注解
 * @author: charon
 * @create: 2019-12-29 20:44
 **/
@Slf4j
@WebMvcTest(ArticleRestController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ArticleVORestControllerTest3 {
    // mock对象
    @Resource
    private MockMvc mockMvc;

    @MockBean
    private ArticleRestServiceJPAImpl articleRestServiceJPAImpl;

    @Test
    public void saveArticle() throws Exception {
        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"charon\",\n" +
                "    \"title\": \"spring boot\",\n" +
                "    \"content\": \"content\",\n" +
                "    \"createTime\": \"2019-12-29 12:44:30\",\n" +
                "    \"reader\":[{\"name\":\"cahron\",\"age\":22},{\"name\":\"crane\",\"age\":23}]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        ArticleVO articleVOObj = objectMapper.readValue(article, ArticleVO.class);
        // 打桩
        when(articleRestServiceJPAImpl.saveArticle(articleVOObj)).thenReturn(articleVOObj);

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/article")
                        .contentType("application/json").content(article))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("charon"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(22))
                .andDo(print())
                .andReturn();

        log.info(result.getResponse().getContentAsString());
    }

}

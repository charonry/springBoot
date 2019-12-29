package com.charon.boot.mockMvc;

import com.charon.boot.controller.ArticleRestController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @description: 测试Mockito
 * @author: charon
 * @create: 2019-12-29 20:44
 **/
@Slf4j
@SpringBootTest
public class ArticleRestControllerTest {
    // mock对象
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc= MockMvcBuilders.standaloneSetup
                (new ArticleRestController()).build();

    }

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

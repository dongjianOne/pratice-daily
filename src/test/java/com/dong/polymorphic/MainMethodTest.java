package com.dong.polymorphic;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author DongJian
 * @Date Created in 2020/7/14 17:43
 * Utils: Intellij Idea
 * @Description:
 * @Version:1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class MainMethodTest {
    @Autowired
    @Qualifier("dog")
    Dog dog;
    @Autowired
    @Qualifier("cat")
    Cat cat;

    @Test
    void animal() {
        System.out.println(dog.climbUp("dog"));
        System.out.println(cat.climbUp("cat"));
    }


    // -----------------------test mvc user MockMvc-----------------------------//
    @Autowired
    MockMvc mvc;

    @Test
    public void testParam() throws Exception {
        // controller
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/param/1"));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.content().string("1"));
        resultActions.andDo(MockMvcResultHandlers.print());
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println("拦截器数量："+mvcResult.getInterceptors().length);

    }
}
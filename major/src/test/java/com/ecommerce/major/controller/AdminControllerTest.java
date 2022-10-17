package com.ecommerce.major.controller;

import com.ecommerce.major.model.Category;
import com.ecommerce.major.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import javax.net.ssl.SSLEngineResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AdminControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    ObjectMapper om=new ObjectMapper();

    @BeforeEach
    public void setUp()
    {
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }
    /*@Test
    public void postCatTest() throws Exception {
        Category category=new Category("blueberry");
        String jsonrequest=om.writeValueAsString(category);
        MvcResult result= (MvcResult) mockMvc.perform(post("/admin/categories/add")).andExpect(status().isOk());
        //String resultContent=result.getResponse().getContentAsString();
        //Response response= om.readValue(resultContent, Response.class);
        //assertThat(response.isSuccess()).isTrue();
    }*/
    /*@Test
    public void getcategoriesTest() throws Exception {
        MvcResult result= (MvcResult) mockMvc.perform(get("/admin/categories/add").andExpect(status().isOk());
        String resultContent=result.getResponse().getContentAsString();
        Response response= om.readValue(resultContent, Response.class);
        assertThat(response.isSuccess()).isTrue();
    }*/

}

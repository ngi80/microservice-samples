package com.todo.service.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.todo.service.Application;
import com.todo.service.data.model.ToDo;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by nicolasgilmant on 15/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("datalayer.selector.property=mongodb-mock")
public class ToDoRestServiceTest {


    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;


    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetToDo() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/todo-service"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].content", Matchers.is("My ToDo")));
        ;
    }

    @Test
    public void testGetById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/todo-service/0001"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSaveToDo() throws Exception
    {
        ToDo aToDo = new ToDo();
        aToDo.setContent("don't forget to switch off my laptop.");


        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/todo-service").contentType(APPLICATION_JSON_UTF8)
                .content(serializeToDo(aToDo)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateToDo() throws Exception
    {

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/todo-service/0001"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        ToDo aToDo = deserializeToDo(result.getResponse().getContentAsString());
        aToDo.setContent("My updated To Do");


    }

    private String serializeToDo(ToDo aToDo) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(aToDo);
    }

    private ToDo deserializeToDo(String aToDoInJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(aToDoInJson, ToDo.class);
    }

}

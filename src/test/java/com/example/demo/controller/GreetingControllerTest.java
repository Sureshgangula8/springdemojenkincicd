package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greet_withNoParam_returnsHelloWorld() throws Exception {
        mockMvc.perform(get("/greetingdemo"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

    @Test
    void greet_withNameParam_returnsHelloName() throws Exception {
        mockMvc.perform(get("/greetingdemo").param("name", "Suresh"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Suresh!"));
    }
}

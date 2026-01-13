package com.example.fibonacci.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public @SpringBootTest @AutoConfigureMockMvc class FibonacciControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGenerateSeries() throws Exception {
        mockMvc.perform(post("/api/fibonacci")
                .with(httpBasic("admin", "admin123"))
                .contentType(MediaType.APPLICATION_JSON)
                .content("           {\r\n" + //
                        "              \"time\": \"12:23:04\",\r\n" + //
                        "              \"email\": \"test@example.com\"\r\n" + //
                        "            }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.series").isArray())
                .andExpect(jsonPath("$.executionTime").value("12:23:04"));
    }
}

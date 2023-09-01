package com.example.demo.controller;

import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class StudentControllerTest extends TestContainers {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepository repository;


    @Test
    @DisplayName("Should retrieve all students with default parameters")
    void shouldRetrieveAllStudentsWithDefaultParameters() throws Exception {
        mockMvc.perform(get("/students"))
                .andDo(print())
                .andExpect(status().isPartialContent())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.students", hasSize(10)))
                .andExpect(jsonPath("$.pageNumber").value(1))
                .andExpect(jsonPath("$.totalElements").value(45))
                .andExpect(jsonPath("$.totalPages").value(5))
                .andExpect(jsonPath("$.lastPage").value(Boolean.FALSE));
    }


    @Test
    @DisplayName("Should retrieve all students with default parameters")
    void shouldRetrieveAllStudentsWithCustomParameters() throws Exception {
        mockMvc.perform(get("/students")
                        .param("pageNumber","9")
                        .param("size","5")
                        .param("sort","name")
                        .param("direction","ASC"))
                .andDo(print())
                .andExpect(status().isPartialContent())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.students", hasSize(5)))
                .andExpect(jsonPath("$.pageNumber").value(9))
                .andExpect(jsonPath("$.totalElements").value(45))
                .andExpect(jsonPath("$.totalPages").value(9))
                .andExpect(jsonPath("$.lastPage").value(Boolean.TRUE));
    }

}

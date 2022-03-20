package com.example.demo.integration;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BookPostgresSQLTest extends AbstractIntegrationTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
    }


    @Test
    @Order(1)
    void should_be_able_to_save_one_book() throws Exception {
        // Given
        final var book = new Book();
        book.setAuthor("Alain de Botton");
        book.setTitle("The school of life");
        book.setYear(2012);

        // When & Then
        mockMvc.perform(post("/create/book")
                        .content(new ObjectMapper().writeValueAsString(book))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.author").value("Alain de Botton"))
                .andExpect(jsonPath("$.title").value("The school of life"))
                .andExpect(jsonPath("$.year").value("2012"));
    }

    @Test
    @Order(2)
    void should_be_able_to_retrieve_all_book() throws Exception {
        // Given
        bookRepository.saveAll(List.of(new Book(), new Book(), new Book()));

        // When
        mockMvc.perform(get("/fetch/books")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

        // Then
        assertThat(bookRepository.findAll()).hasSize(3);
    }

}

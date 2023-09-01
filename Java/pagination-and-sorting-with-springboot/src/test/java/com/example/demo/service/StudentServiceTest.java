package com.example.demo.service;

import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    private StudentService service;

    @Mock
    private StudentRepository repository;

    @Test
    @DisplayName("Should fetch all the students in the database")
    void shouldFetchAllTheStudentInDatabase() {
        // Arrange
        var students = mock(Page.class);
        when(repository.findAll(any(PageRequest.class))).thenReturn(students);

        // Act
        service.findAllStudents(PageRequest.of(1, 10, Sort.Direction.ASC, "name"));

        // Assert
        verify(repository).findAll(any(PageRequest.class));
        verifyNoMoreInteractions(repository);
    }

}
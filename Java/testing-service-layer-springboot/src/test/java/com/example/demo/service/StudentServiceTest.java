package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudentServiceTest {

    @InjectMocks
    private StudentService service;

    @Mock
    private StudentRepository repository;

    @Test
    void should_save_one_student() {
        // Arrange
        final var studentToSave = Student.builder().name("Mary Jane").age(25).build();
        when(repository.save(any(Student.class))).thenReturn(studentToSave);

        // Act
        final var actual = service.saveOneStudent(new Student());

        // Assert
        assertThat(actual).usingRecursiveComparison().isEqualTo(studentToSave);
        verify(repository, times(1)).save(any(Student.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void should_find_and_return_one_student() {
        // Arrange
        final var expectedStudent = Student.builder().name("Jimmy Olsen").age(28).build();
        when(repository.findById(anyInt())).thenReturn(Optional.of(expectedStudent));

        // Act
        final var actual = service.findOneStudent(getRandomInt());

        // Assert
        assertThat(actual).usingRecursiveComparison().isEqualTo(expectedStudent);
        verify(repository, times(1)).findById(anyInt());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void should_not_found_a_student_that_doesnt_exists() {
        // Arrange
        when(repository.findById(anyInt())).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(EntityNotFoundException.class, () -> service.findOneStudent(getRandomInt()));
        verify(repository, times(1)).findById(anyInt());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void should_find_and_return_all_student() {
        // Arrange
        when(repository.findAll()).thenReturn(List.of(new Student(), new Student()));

        // Act & Assert
        assertThat(service.findAllStudent()).hasSize(2);
        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void should_delete_one_student() {
        // Arrange
        doNothing().when(repository).deleteById(anyInt());

        // Act & Assert
        service.deleteOneStudent(getRandomInt());
        verify(repository, times(1)).deleteById(anyInt());
        verifyNoMoreInteractions(repository);
    }

    private int getRandomInt() {
        return new Random().ints(1, 10).findFirst().getAsInt();
    }
}
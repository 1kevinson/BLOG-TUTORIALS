package com.example.demo.example.controller;

import com.example.demo.example.dto.StudentCreationDto;
import com.example.demo.example.dto.StudentViewDto;
import com.example.demo.example.repository.StudentRepository;
import com.example.demo.example.util.StudentConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Random;

@Controller
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentRepository repository;

    @GetMapping("/{id}")
    @ResponseBody
    public StudentViewDto getStudent(@PathVariable Long id) {
        final var fetchedStudent = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return StudentConverter.toViewDto(fetchedStudent, fetchedStudent.getSchool());
    }

    @PostMapping
    @ResponseBody
    public StudentViewDto saveStudent(@RequestBody StudentCreationDto studentCreationDto) {
        // Get the school by address in database => studentCreationDto.getSchoolAddress()

        final Long schoolId = new Random().nextLong(); // <= Set the school ID with which retrieved in database
        final var studentToSave = StudentConverter.toEntity(studentCreationDto, schoolId);
        final var studentSaved = repository.save(studentToSave);

        return StudentConverter.toViewDto(studentSaved, studentSaved.getSchool());
    }
}

package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    Student saveOneStudent(Student student) {
        final var studentToSave = Student.builder()
                .name(student.getName())
                .age(student.getAge())
                .gender(student.getGender())
                .address(student.getAddress())
                .build();

        return this.repository.save(studentToSave);
    }

    Student findOneStudent(int studentId) {
        return this.repository.findById(studentId).orElseThrow(EntityNotFoundException::new);
    }

    List<Student> findAllStudent() {
        return IterableUtils.toList(this.repository.findAll());
    }

    void deleteOneStudent(int studentId) {
        this.repository.deleteById(studentId);
    }
}

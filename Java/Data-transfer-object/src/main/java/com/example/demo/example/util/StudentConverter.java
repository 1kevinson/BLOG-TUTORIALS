package com.example.demo.example.util;

import com.example.demo.example.domain.School;
import com.example.demo.example.domain.Student;
import com.example.demo.example.dto.StudentCreationDto;
import com.example.demo.example.dto.StudentViewDto;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public static StudentViewDto toViewDto(Student student, School school) {
        return StudentViewDto.builder()
                .name(student.getName())
                .email(student.getEmail())
                .schoolName(school.getName())
                .build();
    }

    public static Student toEntity(StudentCreationDto studentCreationDto, Long schoolId) {
        final var schoolForStudent = School.builder()
                .id(schoolId)
                .name(studentCreationDto.getSchoolName())
                .address(studentCreationDto.getSchoolAddress())
                .build();

        return  Student.builder()
                .name(studentCreationDto.getName())
                .email(studentCreationDto.getEmail())
                .password(PasswordManager.encrypt(studentCreationDto.getPassword()))
                .school(schoolForStudent)
                .build();
    }
}

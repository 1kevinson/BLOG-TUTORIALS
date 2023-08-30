package com.example.demo.service;

import com.example.demo.model.ResponseModel;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public ResponseModel findAllStudents(PageRequest pageable) {
        var studentsPage= this.repository.findAll(pageable);
        return buildResponse(studentsPage);
    }

    private ResponseModel buildResponse(Page studentsPage){
        return ResponseModel.builder()
                .pageNumber(studentsPage.getNumber() + 1)
                .pageSize(studentsPage.getSize())
                .totalElements(studentsPage.getTotalElements())
                .totalPages(studentsPage.getTotalPages())
                .students(studentsPage.toList())
                .isLastPage(studentsPage.isLast())
                .build();
    }

}

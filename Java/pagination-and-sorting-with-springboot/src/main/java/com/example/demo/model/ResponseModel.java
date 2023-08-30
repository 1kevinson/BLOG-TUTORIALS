package com.example.demo.model;

import com.example.demo.entity.Student;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ResponseModel {

    private final List<Student> students;
    private final int pageNumber;
    private final int pageSize;
    private final long totalElements;
    private final int totalPages;
    private final boolean isLastPage;

}

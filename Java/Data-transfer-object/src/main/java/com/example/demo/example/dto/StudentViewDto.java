package com.example.demo.example.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentViewDto {

    private String name;
    private String email;
    private String schoolName;

}

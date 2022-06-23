package com.example.demo.example.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentCreationDto {

    private String name;
    private String email;
    private String password;
    private String schoolName;
    private String schoolAddress;

}

package com.example.demo.example.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Student {

    private Long id;
    private String name;
    private String email;
    private String password;
    private School school;
}

package com.example.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {

    private String name;
    private String email;
    private String address;
    private String phone;
    private String dateOfBirth;
}

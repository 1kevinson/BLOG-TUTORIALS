package com.example.demo.example.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class School {

    private Long id;
    private String name;
    private String address;
}

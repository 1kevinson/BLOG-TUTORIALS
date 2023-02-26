package com.example.demo.payload;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private String type;
    private String title;
    private String detail;
    private String instane;
}

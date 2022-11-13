package com.example.demo.files;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EmailRequest {

    @Email
    private String email;

    @NotBlank
    private String content;
}

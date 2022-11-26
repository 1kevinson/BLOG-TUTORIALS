package com.example.demo.files;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {

    @Email
    private String email;

    @NotBlank
    private String content;
}

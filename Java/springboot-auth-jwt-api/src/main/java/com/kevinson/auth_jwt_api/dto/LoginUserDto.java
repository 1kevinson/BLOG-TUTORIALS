package com.kevinson.auth_jwt_api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginUserDto {

    private String email;
    private String password;
}

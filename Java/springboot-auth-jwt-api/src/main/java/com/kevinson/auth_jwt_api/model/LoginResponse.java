package com.kevinson.auth_jwt_api.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

    private String token;
    private long expiresIn;
}

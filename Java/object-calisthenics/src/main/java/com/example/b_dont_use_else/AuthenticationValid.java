package com.example.b_dont_use_else;

import java.util.Random;

public class AuthenticationValid {

    private final UserRepositoryValid userRepository = new UserRepositoryValid();

    public void login(String username, String password) {
        String redirectRoute = "homepage";

        if (!userRepository.isValid(username, password)) {
            addFlash("errorCode", "Bad credentials");
            redirectRoute = "login";
        }

        redirect(redirectRoute);
    }

    void addFlash(String key, String value) {}
    void redirect(String url) {}
}

class UserRepositoryValid {
    boolean isValid(String username, String password) {
        return new Random().nextBoolean();
    }
}



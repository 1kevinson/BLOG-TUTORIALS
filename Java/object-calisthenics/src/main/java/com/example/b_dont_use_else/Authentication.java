package com.example.b_dont_use_else;

public class Authentication {

    private final UserRepository userRepository = new UserRepository();

    public void login(String username, String password) {
        if (userRepository.isValid(username, password)) {
            redirect("homepage");
        } else {
            throwException("errorCode", "Bad credentials");
            redirect("loginRoute");
        }
    }

    void throwException(String key, String value) {}
    void redirect(String url) {}
}

class UserRepository {
    boolean isValid(String username, String password) {
        return true;
    }
}



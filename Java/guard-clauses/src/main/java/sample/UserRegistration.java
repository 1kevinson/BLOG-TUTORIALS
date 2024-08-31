package sample;

import org.apache.commons.lang3.exception.ContextedRuntimeException;

public class UserRegistration {

    public String registerUser(String username, String password, String email) {
        String validationMessage = null;

        if (username == null || username.isEmpty()) {
            validationMessage = "Username is required.";
        } else if (password == null || password.isEmpty()) {
            validationMessage = "Password is required.";
        } else if (email == null || !email.contains("@")) {
            validationMessage = "Valid email is required.";
        }

        if (validationMessage != null) {
            throw new ContextedRuntimeException();
        }

        // Proceed with registration if all validations are passed
        saveToDatabase(username, password, email);

        return "User registered successfully.";
    }

    private void saveToDatabase(String username, String password, String email) {
        // execute saving to a database
        System.out.println("User" + username + " with email: " + email);
    }

}
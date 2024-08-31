package sample;

import org.apache.commons.lang3.exception.ContextedException;
import sample.helper.UserGuard;

public class UserRegistrationWithGuardHelper {

    public String registerUser(String username, String password, String email) throws ContextedException {

        UserGuard.againstInvalidUser(username);
        UserGuard.againstInvalidPassword(password);
        UserGuard.againstInvalidEmail(email);

        // Proceed with registration if all validations are passed
        saveToDatabase(username, password, email);
        return "User registered successfully.";
    }

    private void saveToDatabase(String username, String password, String email) {
        // Simulate saving to a database
        System.out.println("User saved: " + username);
    }

}

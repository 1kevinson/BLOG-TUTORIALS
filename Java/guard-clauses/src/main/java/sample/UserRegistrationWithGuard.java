package sample;

public class UserRegistrationWithGuard {

    public String registerUser(String username, String password, String email) {
        if (username == null || username.isEmpty()) {
            return "Username is required.";
        }

        if (password == null || password.isEmpty()) {
            return "Password is required.";
        }

        if (email == null || !email.contains("@")) {
            return "Valid email is required.";
        }

        // Proceed with registration if all validations are passed
        saveToDatabase(username, password, email);
        return "User registered successfully.";
    }

    private void saveToDatabase(String username, String password, String email) {
        // Simulate saving to a database
        System.out.println("User saved: " + username);
    }

}

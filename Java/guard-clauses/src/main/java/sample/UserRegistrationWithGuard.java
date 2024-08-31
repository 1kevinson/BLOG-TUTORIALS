package sample;

public class UserRegistrationWithGuard {

    public String registerUser(String username, String password, String email) {
        if (username == null || username.isEmpty()) {
            throw new IllegalStateException("Username is required.");
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalStateException("Password is required.");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalStateException("Valid email is required.");
        }

        saveToDatabase(username, password, email);
        return "User registered successfully.";
    }

    private void saveToDatabase(String username, String password, String email) {
        System.out.println("User saved: " + username);
    }

}

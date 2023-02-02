package com.example;

import com.example.entity.database.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        User user = new User();
        user.setName("Arsene Kevin");
        user.setEmail("kevin.mail@hg.fr");

        userRepository.save(user);
    }
}

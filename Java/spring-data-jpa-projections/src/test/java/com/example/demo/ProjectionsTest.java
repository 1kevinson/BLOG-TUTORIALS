package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.projections.UserView;
import com.example.demo.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
@ActiveProfiles("test")
class ProjectionsTest extends AbstractIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();

        int numberOfUsers = 0;
        var users = new ArrayList<User>();

        while (numberOfUsers < 5) {
            var faker = new Faker(Locale.ENGLISH);
            var user = User.builder()
                    .username(numberOfUsers == 2 ? "1kevinson" : faker.name().username())
                    .password(faker.crypto().md5())
                    .email(numberOfUsers == 2 ? "anomynous@gmail.com" : "anomynous@test.com")
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .build();

            users.add(user);
            numberOfUsers++;
        }

        userRepository.saveAll(users);
    }

    @Test
    void testFetchUserByEmailServer() {
        List<UserView> userViews = userRepository.fetchUsersByEmailServer("gmail");

        assertThat(userViews).hasSize(1);
        assertThat(userViews.get(0).getUsername()).isEqualTo("1kevinson");
        assertThat(userViews.get(0).getEmail()).isEqualTo("anomynous@gmail.com");
    }

}

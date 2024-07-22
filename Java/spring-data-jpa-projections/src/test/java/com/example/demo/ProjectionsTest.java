package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.projections.UserDto;
import com.example.demo.projections.UserView;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.List;

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

        var users = new ArrayList<User>();

        var user1 = User.builder().lastName("kev").username("1kevinson").email("anomynous@gmail.com").build();
        var user2 = User.builder().lastName("brad").username("bradleyVost").email("bradley_v@yahoo.com").build();
        var user3 = User.builder().lastName("mel").username("melindaKane").email("kane_m@hotmail.fr").build();

        users.add(user1);
        users.add(user2);
        users.add(user3);

        userRepository.saveAll(users);
    }

    @Test
    void testFetchUserByEmailServerUsingOpenProjection() {
        List<UserView> userViews = userRepository.fetchUsersByEmailServer("gmail");

        assertThat(userViews).hasSize(1);
        assertThat(userViews.get(0).getUsername()).isEqualTo("1kevinson");
        assertThat(userViews.get(0).getEmail()).isEqualTo("anomynous@gmail.com");
    }

    @Test
    void testFetchFullNameByEmailServerUsingClosedProjection() {
        var user = userRepository.findOne(Example.of(User.builder().username("1kevinson").build()));

        if (user.isPresent()) {
            user.get().setFirstName("Kevin");
            user.get().setLastName("Kouomeu");
            userRepository.save(user.get());
        }

        var userView = userRepository.findByEmailLike("%gmail%");

        assertThat(userView.getUsername()).isEqualTo("1kevinson");
        assertThat(userView.getEmail()).isEqualTo("anomynous@gmail.com");
        assertThat(userView.getFullName()).isEqualTo("Kevin Kouomeu");
    }

    @Test
    void testFetchUserByUsernameUsingProjection() {
        var userDto = userRepository.findByUsername("1kevinson");

        assertThat(userDto.getEmail()).isEqualTo("anomynous@gmail.com");
    }

    @Test
    void testFetchUserByLastnameUsingDynamicProjection() {
        User user = userRepository.findByLastName("kev", User.class);
        UserDto userDto = userRepository.findByLastName("kev", UserDto.class);
        UserView userView = userRepository.findByLastName("kev", UserView.class);

        assertThat(user.getUsername()).isEqualTo("1kevinson");
        assertThat(userDto.getUsername()).isEqualTo("1kevinson");
        assertThat(userView.getUsername()).isEqualTo("1kevinson");
    }

}

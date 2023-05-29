package com.example.demo.e2e;

import com.example.DemoApplication;
import com.example.demo.TestContainers;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("prod")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = DemoApplication.class
)
@TestPropertySource(locations = "classpath:application-prod.yml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class BaseE2E extends TestContainers {

}

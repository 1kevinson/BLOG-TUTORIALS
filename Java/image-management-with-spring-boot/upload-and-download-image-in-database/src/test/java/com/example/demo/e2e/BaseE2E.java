package com.example.demo.e2e;

import com.example.demo.TestContainers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class BaseE2E extends TestContainers {

}

package com.example.demo.service;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Random;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudentServiceTest {

    @Test
    void troubleshooting() {
        System.out.println(new Random().nextInt(26 - 17) + 17);
    }

}
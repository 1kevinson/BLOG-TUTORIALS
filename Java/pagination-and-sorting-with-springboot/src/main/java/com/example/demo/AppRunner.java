package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {

    public static final int MAX_AGE = 26;
    public static final int MIN_AGE = 17;
    private static int NUMBER_OF_STUDENTS = 45;
    private final StudentRepository repository;

    @Override
    public void run(String... args) {
        var faker = new Faker(new Locale("fr"));
        var students = new ArrayList<Student>();

        while (NUMBER_OF_STUDENTS > 0) {
            var student = Student.builder()
                    .name(faker.name().fullName())
                    .age(new Random().nextInt(MAX_AGE - MIN_AGE) + MIN_AGE)
                    .address(faker.address().fullAddress())
                    .build();
            students.add(student);
            NUMBER_OF_STUDENTS--;
        }

        repository.saveAll(students);
    }

}

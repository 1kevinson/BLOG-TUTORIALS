package com.example.demo.launcher;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import static java.util.Locale.FRANCE;
import static java.util.Locale.FRENCH;

@Component
@RequiredArgsConstructor
public class EmployeeLoader implements CommandLineRunner {

    private static int NUMBER_OF_EMPLOYEES = 85;
    private final EmployeeRepository repository;

    @Override
    public void run(String... args) {
        var faker = new Faker(new Locale(FRENCH.getLanguage(), FRANCE.getCountry()));
        ArrayList<Employee> employees = new ArrayList<>();

        while (NUMBER_OF_EMPLOYEES > 0) {
            var student = Employee.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .salary(BigDecimal.valueOf(generateRandomSalary()))
                    .address(faker.address().fullAddress())
                    .role(faker.company().profession())
                    .matricule(faker.code().asin())
                    .build();
            employees.add(student);
            NUMBER_OF_EMPLOYEES--;
        }

        repository.saveAll(employees);
    }

    private static int generateRandomSalary() {
        return new Random().nextInt((120000 - 40000) / 100 + 1) * 100 + 40000;
    }
}


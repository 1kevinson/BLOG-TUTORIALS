package com.example;

import com.example.domain.Person;
import com.example.utils.JsonLogger;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class App {

    public static void main(String[] args) {
        int count = 0;
        List<Person> persons = new ArrayList<>();

        while (count < 4) {
            Faker faker = new Faker(Locale.CANADA);

            Person person = Person.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress().toLowerCase())
                    .phone(faker.phoneNumber().cellPhone())
                    .address(faker.address().fullAddress())
                    .dateOfBirth(new SimpleDateFormat("yyyy-MM-dd")
                            .format(faker.date().birthday()))
                    .build();

            persons.add(person);
            count++;
        }

        JsonLogger.info("Persons", persons);
    }
}

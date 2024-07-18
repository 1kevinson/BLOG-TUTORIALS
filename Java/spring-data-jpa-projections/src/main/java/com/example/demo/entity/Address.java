package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
public class Address {

    public Address() {

    }

    @Id
    private Long id;

    @OneToOne
    private User user;

    private String state;

    private String city;

    private String street;

    private String zipCode;

    // getters and setters

}

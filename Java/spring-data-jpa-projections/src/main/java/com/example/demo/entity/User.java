package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@Table(name = "users")
public class User {

    public User() {
        // No-args constructor for Hibernate Reflection
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    @OneToOne(mappedBy = "user")
    private Address address;

}

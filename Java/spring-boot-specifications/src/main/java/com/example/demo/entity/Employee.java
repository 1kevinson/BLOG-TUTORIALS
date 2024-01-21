package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "employee")
public class Employee extends BaseEntity {

    public Employee() {
    }

    @Id
    @GeneratedValue
    @Column(nullable = false)
    @UuidGenerator(style = Style.TIME)
    private long uuid;

    @Column(name = "email", nullable = false)
    @NotNull(message = "The name cannot be null")
    private String name;

    @Column(name = "email", nullable = false)
    @NotNull(message = "An employee should always have an email")
    private String email;

    @Column(name = "address", nullable = false)
    @NotNull(message = "An employee should always have an address")
    private String address;

    @Column(name = "matricule", nullable = false)
    @NotNull(message = "An employee should always have a matricule")
    private String matricule;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "role")
    private String role;
}

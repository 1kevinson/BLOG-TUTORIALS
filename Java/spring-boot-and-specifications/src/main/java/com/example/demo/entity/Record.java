package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Record extends BaseEntity {

    public Record() {
        // No-args constructor for Hibernate Reflection
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address")
    private String address;

    @Column(name = "salary")
    private BigDecimal salary;
}

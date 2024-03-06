package com.example.demo.specification;

import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecs {

    public static Specification<EmployeeSpecs> isHighSalary() {
        return ((root, query, criteriaBuilder) -> {

        })
    }
}

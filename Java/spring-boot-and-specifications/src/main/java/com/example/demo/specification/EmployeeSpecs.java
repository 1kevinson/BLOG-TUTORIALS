package com.example.demo.specification;

import com.example.demo.entity.Record;
import com.example.demo.entity.Record_;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class EmployeeSpecs {

    public static Specification<Record> areHighSalary() {
        return (root, query, builder) -> builder.greaterThan(
                root.get(Record_.SALARY), BigDecimal.valueOf(80000)
        );
    }

    public static Specification<Record> areYoungWorkers() {
        return (root, query, builder) -> builder.lessThan(
                root.get(Record_.AGE), 27
        );
    }
}

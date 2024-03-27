package com.example.demo.specification;

import com.example.demo.entity.Record;
import com.example.demo.entity.Record_;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

public class EmployeeSpecs {

    private EmployeeSpecs() {
        // Enforcing object construction through builder
    }

    public static class Builder {

        private Specification<Record> havingHighSalaries;
        private Specification<Record> areYoungWorkers;

        public Builder() {
            // Default implementation ignored
        }

        public Builder havingHighSalaries() {
            this.havingHighSalaries = employeesHavingHighSalary();
            return this;
        }

        public Builder areYoungWorkers(Integer age) {
            if (nonNull(age)) this.areYoungWorkers = employeeAreYoungWorkers(age);
            return this;
        }

        public Specification<Record> build() {
            return Specification.where(this.areYoungWorkers)
                    .and(this.havingHighSalaries);
        }

        private static Specification<Record> employeesHavingHighSalary() {
            return (root, query, builder) -> builder.greaterThan(
                    root.get(Record_.SALARY), BigDecimal.valueOf(65000)
            );
        }

        private static Specification<Record> employeeAreYoungWorkers(Integer age) {
            return (root, query, builder) -> builder.lessThan(
                    root.get(Record_.AGE), age
            );
        }
    }

}

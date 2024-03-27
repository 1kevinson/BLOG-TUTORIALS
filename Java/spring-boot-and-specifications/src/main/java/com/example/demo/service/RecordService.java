package com.example.demo.service;

import com.example.demo.entity.Record;
import com.example.demo.repository.RecordRepository;
import com.example.demo.specification.EmployeeSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository repository;

    public List<Record> findAllHighSalary() {
        Specification<Record> specifications = new EmployeeSpecs.Builder()
                .havingHighSalaries()
                .build();

        return repository.findAll(specifications);
    }

    public List<Record> findAllYoungEmployeesWithHighSalaries(Integer age) {
        if (Objects.isNull(age)) return findAllHighSalary();

        Specification<Record> specifications = new EmployeeSpecs.Builder()
                .havingHighSalaries()
                .areYoungWorkers(age)
                .build();

        return repository.findAll(specifications);
    }
}

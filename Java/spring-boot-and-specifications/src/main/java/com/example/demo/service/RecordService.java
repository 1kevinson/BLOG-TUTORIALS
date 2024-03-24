package com.example.demo.service;

import com.example.demo.entity.Record;
import com.example.demo.repository.RecordRepository;
import com.example.demo.specification.EmployeeSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository repository;

    public List<Record> findAll() {
        Specification<Record> specifications = EmployeeSpecs.areHighSalary();
        return repository.findAll(specifications);
    }
}

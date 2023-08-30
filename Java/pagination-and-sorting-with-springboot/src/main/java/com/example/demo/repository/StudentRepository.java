package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, UUID>, CrudRepository<Student, UUID> {}

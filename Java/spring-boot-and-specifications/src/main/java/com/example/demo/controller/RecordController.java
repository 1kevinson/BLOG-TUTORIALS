package com.example.demo.controller;

import com.example.demo.entity.Record;
import com.example.demo.service.RecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class RecordController {

    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Record>> getYoungEmployeeWithHighSalaries(@RequestParam(value = "age", required = false) Integer age) {
        return new ResponseEntity<>(service.findAllYoungEmployeesWithHighSalaries(age), HttpStatus.OK);
    }
}

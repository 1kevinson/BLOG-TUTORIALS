package com.example.e_use_one_dot_per_line;

public class Employee {
    private Department department;

    Department getDepartment() {
        return department;
    }
}

class Department {
    private String manager;

    public String getManager() {
        return manager;
    }
}

class Practice {

    public String getEmployeeManager() {
        EmployeeValid employeeValid = new EmployeeValid();
        return employeeValid.getDepartment().getManager();
    }
}
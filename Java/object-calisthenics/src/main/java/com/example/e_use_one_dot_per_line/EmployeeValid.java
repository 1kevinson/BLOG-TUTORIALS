package com.example.e_use_one_dot_per_line;

public class EmployeeValid {
    private DepartmentValid departmentValid;

    DepartmentValid getDepartment() {
        return departmentValid;
    }

    String getEmployeeManager() {
        return departmentValid.getManager();
    }
}

class DepartmentValid {
    private String manager;

    public String getManager() {
        return manager;
    }
}

class PracticeValid {

    public String getEmployeeManager() {
        EmployeeValid employeeValid = new EmployeeValid();
        return employeeValid.getEmployeeManager();
    }
}
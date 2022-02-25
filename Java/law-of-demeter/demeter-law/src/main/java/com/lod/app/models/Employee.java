package com.lod.app.models;

public class Employee {

    private final String name;
    private final Enterprise enterprise;

    public Employee(String name, Enterprise enterprise) {
        this.name = name;
        this.enterprise = enterprise;
    }

    public String getName() {
        return name;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public int getEnterprisePostalCode() {
        return this.enterprise.getAddressPostalCode();
    }
}

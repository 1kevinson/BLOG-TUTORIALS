package com.lod.app.models;

public class Enterprise {

    private final int employeeNumbers;
    private final String domain;
    private final Address address;

    public Enterprise(int employeeNumbers, String domain, Address address) {
        this.employeeNumbers = employeeNumbers;
        this.domain = domain;
        this.address = address;
    }

    public int getEmployeeNumbers() {
        return employeeNumbers;
    }

    public String getDomain() {
        return domain;
    }

    public Address getAddress() {
        return address;
    }

    public int getAddressPostalCode() {
        return this.address.getPostalCode();
    }
}

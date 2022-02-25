package com.lod.app;

import com.lod.app.models.Address;
import com.lod.app.models.Employee;
import com.lod.app.models.Enterprise;

public class App {

    public static void main(String[] args) {
        final Address address = new Address("15 Rue des paresseux", 78400, "Paris");
        final Enterprise enterprise = new Enterprise(200, "Technologies", address);
        final Employee employee = new Employee("Roger Klunt", enterprise);

        System.out.println(employee.getEnterprise().getAddress().getPostalCode());
        System.out.println(employee.getEnterprisePostalCode());
    }
}

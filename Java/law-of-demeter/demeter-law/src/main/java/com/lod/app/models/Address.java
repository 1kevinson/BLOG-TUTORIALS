package com.lod.app.models;

public class Address {

    private final String street;
    private final int postalCode;
    private final String city;

    public Address(String street, int postalCode, String city) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}

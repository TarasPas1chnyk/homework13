package org.example.task1;

public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;


    public Address(String street, String suite, String city, String zipcode, Geo geo, Company company) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                ", company=" + company +
                '}';
    }

    private Company company;
}
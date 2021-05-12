package at.mps.domain;

import java.util.List;

public class Account {

    private int id;
    private  String email;
    private String firstName;
    private List<String> middleName;
    private String surName;
    private int houseNumber;
    private String street;
    private String zipCode;
    private String city;


    public Account(int id, String email, String firstName, List<String> middleName, String surName, int houseNumber, String street, String zipCode, String city) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surName = surName;
        this.houseNumber = houseNumber;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }
}

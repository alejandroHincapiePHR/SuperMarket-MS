package com.ms.supermarket.management.bill.domain.admin;
import com.ms.supermarket.management.bill.domain.base.Domain;



public class Person extends Domain {
    private String firstName;
    private String lastName;
    private String identification;
    private String email;
    private String phoneNumber;

    public Person() {
        super();
    }

    public Person(Long id) {
        super(id);
    }

    public Person(String firstName, String lastName, String identification,
                  String email, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

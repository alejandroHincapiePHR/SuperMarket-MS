package com.ms.supermarket.management.bill.domain.admin;

public class Customer extends Person {


    private Integer points;

    public Customer() {
        super();
    }
    public Customer(Long id) {
        super(id);
    }

    public Customer(String firstName, String lastName, String identification, String email, String phoneNumber, boolean isEmployee, Integer points) {
        super(firstName, lastName, identification, email, phoneNumber);

        this.points = points;
    }



    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}



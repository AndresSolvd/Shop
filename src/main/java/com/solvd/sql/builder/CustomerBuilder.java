package com.solvd.sql.builder;

import com.solvd.sql.model.Customer;
import com.solvd.sql.model.Person;

public class CustomerBuilder {
    private int id;
    private String taxNumber;
    private Person person;

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder withTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
        return this;
    }

    public CustomerBuilder withPerson(Person person) {
        this.person = person;
        return this;
    }

    public Customer build() {
        Customer customer = new Customer();
        customer.setId(this.id);
        customer.setTaxNumber(this.taxNumber);
        customer.setPerson(this.person);
        return customer;
    }
}

package com.solvd.sql.builder;

import com.solvd.sql.model.Person;

public class PersonBuilder {
    private int id;
    private String personName;
    private String lastName;
    private String phone;
    private String address;

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public PersonBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public PersonBuilder withPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public PersonBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = new Person();
        person.setId(this.id);
        person.setPersonName(this.personName);
        person.setLastName(this.lastName);
        person.setPhone(this.phone);
        person.setAddress(this.address);
        return person;
    }
}

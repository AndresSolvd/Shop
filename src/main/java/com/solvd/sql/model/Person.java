package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "person")
@JsonRootName("person")
public class Person {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "personName")
    @JsonProperty("personName")
    private String personName;

    @XmlElement(name = "lastName")
    @JsonProperty("lastName")
    private String lastName;

    @XmlElement(name = "phone")
    @JsonProperty("phone")
    private String phone;

    @XmlElement(name = "address")
    @JsonProperty("address")
    private String address;

    // Private constructor for Builder pattern
    private Person(Builder builder) {
        this.id = builder.id;
        this.personName = builder.personName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    // Private constructor for MyBatis
    private Person() {
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // Inner Builder class
    public static class Builder {
        private int id;
        private String personName;
        private String lastName;
        private String phone;
        private String address;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withPersonName(String personName) {
            this.personName = personName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
@JsonRootName("customer")
public class Customer {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "taxNumber")
    @JsonProperty("taxNumber")
    private String taxNumber;

    @XmlElement(name = "person")
    @JsonProperty("person")
    private Person person;

    // Private builder constructor
    private Customer(Builder builder) {
        this.id = builder.id;
        this.taxNumber = builder.taxNumber;
        this.person = builder.person;
    }

    // Constructor for MyBatis
    private Customer() {
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", taxNumber='" + taxNumber + '\'' +
                ", person=" + person +
                '}';
    }

    // Inner Builder class
    public static class Builder {
        private int id;
        private String taxNumber;
        private Person person;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withTaxNumber(String taxNumber) {
            this.taxNumber = taxNumber;
            return this;
        }

        public Builder withPerson(Person person) {
            this.person = person;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}

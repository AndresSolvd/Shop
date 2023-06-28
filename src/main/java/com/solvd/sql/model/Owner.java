package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "owner")
@JsonRootName(value = "owner")
public class Owner {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "person", type = Person.class)
    @JsonProperty("person")
    private Person person;

    // Private constructor for Builder pattern
    private Owner(Builder builder) {
        this.id = builder.id;
        this.person = builder.person;
    }

    // Private constructor for MyBatis
    private Owner() {
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", person=" + person +
                '}';
    }

    // Inner Builder class
    public static class Builder {
        private int id;
        private Person person;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withPerson(Person person) {
            this.person = person;
            return this;
        }

        public Owner build() {
            return new Owner(this);
        }
    }
}
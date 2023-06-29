package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "staff")
@JsonRootName(value = "staff")
public class Staff {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "position")
    @JsonProperty("position")
    private String position;

    @XmlElement(name = "person", type = Person.class)
    @JsonProperty("person")
    private Person person;

    @XmlElement(name = "shop", type = Shop.class)
    @JsonProperty("shop")
    private Shop shop;

    // Private constructor for the builder
    private Staff(Builder builder) {
        this.id = builder.id;
        this.position = builder.position;
        this.person = builder.person;
        this.shop = builder.shop;
    }

    // Private default constructor for MyBatis
    private Staff() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", person=" + person +
                ", shop=" + shop +
                '}';
    }

    // Inner Builder class
    public static class Builder {
        private int id;
        private String position;
        private Person person;
        private Shop shop;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder withPerson(Person person) {
            this.person = person;
            return this;
        }

        public Builder withShop(Shop shop) {
            this.shop = shop;
            return this;
        }

        public Staff build() {
            return new Staff(this);
        }
    }
}
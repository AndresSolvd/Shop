package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "shop")
@JsonRootName("shop")
public class Shop {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "shopName")
    @JsonProperty("shopName")
    private String shopName;

    @XmlElement(name = "address")
    @JsonProperty("address")
    private String address;

    @XmlElement(name = "phone")
    @JsonProperty("phone")
    private String phone;

    @XmlElement(name = "owner", type = Owner.class)
    @JsonProperty("owner")
    private Owner owner;

    // Private constructor for the builder
    private Shop(Builder builder) {
        this.id = builder.id;
        this.shopName = builder.shopName;
        this.address = builder.address;
        this.phone = builder.phone;
        this.owner = builder.owner;
    }

    // Private default constructor for MyBatis
    private Shop() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", owner=" + owner +
                '}';
    }

    // Inner Builder class
    public static class Builder {
        private int id;
        private String shopName;
        private String address;
        private String phone;
        private Owner owner;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withShopName(String shopName) {
            this.shopName = shopName;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withOwner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public Shop build() {
            return new Shop(this);
        }
    }
}

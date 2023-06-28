package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "supplier")
@JsonRootName(value = "supplier")
public class Supplier {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "supplierName")
    @JsonProperty("supplierName")
    private String supplierName;

    @XmlElement(name = "taxNumber")
    @JsonProperty("taxNumber")
    private String taxNumber;

    @XmlElement(name = "phone")
    @JsonProperty("phone")
    private String phone;

    // Private constructor for the builder
    private Supplier(Builder builder) {
        this.id = builder.id;
        this.supplierName = builder.supplierName;
        this.taxNumber = builder.taxNumber;
        this.phone = builder.phone;
    }

    // Private default constructor for MyBatis
    private Supplier() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", supplierName='" + supplierName + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    // Inner Builder class
    public static class Builder {
        private int id;
        private String supplierName;
        private String taxNumber;
        private String phone;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withSupplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder withTaxNumber(String taxNumber) {
            this.taxNumber = taxNumber;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }
    }
}

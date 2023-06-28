package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.sql.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "orders")
@JsonRootName("orders")
public class Order {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "orderDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("orderDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date orderDate;

    @XmlElement(name = "total")
    @JsonProperty("total")
    private double total;

    @XmlElement(name = "customer", type = Customer.class)
    @JsonProperty("customer")
    private Customer customer;

    // Private constructor for the builder
    private Order(Builder builder) {
        this.id = builder.id;
        this.orderDate = builder.orderDate;
        this.total = builder.total;
        this.customer = builder.customer;
    }

    // Private default constructor for MyBatis
    private Order() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", total=" + total +
                ", customer=" + customer +
                '}';
    }

    // Inner Builder class
    public static class Builder {
        private int id;
        private Date orderDate;
        private double total;
        private Customer customer;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withOrderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder withTotal(double total) {
            this.total = total;
            return this;
        }

        public Builder withCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
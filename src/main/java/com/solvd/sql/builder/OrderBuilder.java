package com.solvd.sql.builder;

import com.solvd.sql.model.Customer;
import com.solvd.sql.model.Order;

import java.sql.Date;

public class OrderBuilder {
    private int id;
    private Date orderDate;
    private double total;
    private Customer customer;

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public OrderBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public OrderBuilder withOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public OrderBuilder withTotal(double total) {
        this.total = total;
        return this;
    }

    public OrderBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Order build() {
        Order order = new Order();
        order.setId(this.id);
        order.setOrderDate(this.orderDate);
        order.setTotal(this.total);
        order.setCustomer(this.customer);
        return order;
    }
}

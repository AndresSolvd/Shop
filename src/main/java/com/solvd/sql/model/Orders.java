package com.solvd.sql.model;

import java.sql.Date;

public class Orders {
    private int id;
    private Date order_date;
    private double total;
    private int customerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", order_date=" + order_date +
                ", total=" + total +
                ", customerId=" + customerId +
                '}';
    }
}

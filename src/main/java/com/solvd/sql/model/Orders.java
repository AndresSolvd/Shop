package com.solvd.sql.model;

import com.solvd.sql.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "orders")
public class Orders {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "order_date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date order_date;

    @XmlElement(name = "total")
    private double total;

    @XmlElement(name = "customerId")
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

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
public class Orders {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "orderDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("orderDate")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date orderDate;

    @XmlElement(name = "total")
    @JsonProperty("total")
    private double total;

    @XmlElement(name = "customerId")
    @JsonProperty("customerId")
    private int customerId;

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
                ", order_date=" + orderDate +
                ", total=" + total +
                ", customerId=" + customerId +
                '}';
    }
}

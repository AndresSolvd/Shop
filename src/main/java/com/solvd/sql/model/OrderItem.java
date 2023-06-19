package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "orderItem")
@JsonRootName(value = "orderItem")
public class OrderItem {

    @XmlElement(name = "quantity")
    @JsonProperty("quantity")
    private int quantity;

    @XmlElement(name = "product", type = Product.class)
    @JsonProperty("product")
    private Product product;

    @XmlElement(name = "order", type = Orders.class)
    @JsonProperty("order")
    private Orders order;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "quantity=" + quantity +
                ", product=" + product +
                ", order=" + order +
                '}';
    }
}
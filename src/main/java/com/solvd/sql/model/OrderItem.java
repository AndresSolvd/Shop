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

    @XmlElement(name = "order", type = Order.class)
    @JsonProperty("order")
    private Order order;

    // Private constructor for the builder
    private OrderItem(Builder builder) {
        this.quantity = builder.quantity;
        this.product = builder.product;
        this.order = builder.order;
    }

    // Private default constructor for MyBatis
    private OrderItem() {
    }

    // Getters and Setters
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
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

    // Inner Builder class
    public static class Builder {
        private int quantity;
        private Product product;
        private Order order;

        public Builder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder withProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder withOrder(Order order) {
            this.order = order;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
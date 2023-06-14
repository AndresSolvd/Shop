package com.solvd.sql.model;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "orderItem")
@JsonRootName(value = "orderItem")
public class OrderItem {

    @XmlElement(name = "quantity")
    @JsonProperty("quantity")
    private int quantity;

    @XmlElement(name = "productId")
    @JsonProperty("productId")
    private int productId;

    @XmlElement(name = "orderId")
    @JsonProperty("orderId")
    private int orderId;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "quantity=" + quantity +
                ", productId=" + productId +
                ", orderId=" + orderId +
                '}';
    }
}
package com.solvd.sql.builder;

import com.solvd.sql.model.Order;
import com.solvd.sql.model.OrderItem;
import com.solvd.sql.model.Product;

public class OrderItemBuilder {
    private int quantity;
    private Product product;
    private Order order;

    public static OrderItemBuilder builder() {
        return new OrderItemBuilder();
    }

    public OrderItemBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderItemBuilder withProduct(Product product) {
        this.product = product;
        return this;
    }

    public OrderItemBuilder withOrder(Order order) {
        this.order = order;
        return this;
    }

    public OrderItem build() {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(this.quantity);
        orderItem.setProduct(this.product);
        orderItem.setOrder(this.order);
        return orderItem;
    }
}

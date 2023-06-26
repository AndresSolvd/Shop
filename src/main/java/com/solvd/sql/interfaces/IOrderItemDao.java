package com.solvd.sql.interfaces;

import com.solvd.sql.model.OrderItem;

public interface IOrderItemDao extends IBaseDAO<OrderItem> {

    OrderItem getOrderByProductName(String name);
}
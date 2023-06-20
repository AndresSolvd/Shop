package com.solvd.sql.interfaces;

import com.solvd.sql.model.Order;

public interface IOrderDao extends IBaseDAO<Order> {

    Order getOrderByCustomerName(String name);
}

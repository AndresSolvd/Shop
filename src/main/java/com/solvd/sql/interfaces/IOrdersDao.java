package com.solvd.sql.interfaces;

import com.solvd.sql.model.Orders;

public interface IOrdersDao extends IBaseDAO<Orders> {

    Orders getOrderByCustomerName(String name);
}

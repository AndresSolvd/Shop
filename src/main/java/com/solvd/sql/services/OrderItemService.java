package com.solvd.sql.services;

import com.solvd.sql.interfaces.IOrderItemDao;
import com.solvd.sql.jdbc.OrderItemDao;
import com.solvd.sql.model.OrderItem;

import java.sql.SQLException;
import java.util.List;

public class OrderItemService implements IOrderItemDao {

    OrderItemDao orderItemDao = new OrderItemDao();

    @Override
    public void insert(OrderItem orderItem) throws SQLException {
        orderItemDao.insert(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) throws SQLException {
        orderItemDao.update(orderItem);
    }

    @Override
    public void delete(int id) throws SQLException {
        orderItemDao.delete(id);
    }

    @Override
    public List<OrderItem> getAll() throws SQLException {
        return orderItemDao.getAll();
    }

    @Override
    public OrderItem getById(int id) throws SQLException {
        return orderItemDao.getById(id);
    }
}

package com.solvd.sql.services;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.jdbc.OrderItemDao;
import com.solvd.sql.model.OrderItem;

import java.sql.SQLException;
import java.util.List;

public class OrderItemService implements IBaseDAO<OrderItem> {

    OrderItemDao orderItemDao = new OrderItemDao();

    @Override
    public void insert(OrderItem orderItem) {
        orderItemDao.insert(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) {
        orderItemDao.update(orderItem);
    }

    @Override
    public void delete(int id) {
        orderItemDao.delete(id);
    }

    @Override
    public List<OrderItem> getAll() {
        return orderItemDao.getAll();
    }

    @Override
    public OrderItem getById(int id) {
        return orderItemDao.getById(id);
    }
}

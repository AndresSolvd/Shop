package com.solvd.sql.services;

import com.solvd.sql.interfaces.IOrderItemDao;
import com.solvd.sql.model.OrderItem;
import com.solvd.sql.mybatis.OrderItemDao;

import java.util.List;

public class OrderItemService implements IOrderItemDao {

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

    @Override
    public OrderItem getByProductName(String name) {
        return orderItemDao.getByProductName(name);
    }
}

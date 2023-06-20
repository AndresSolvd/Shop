package com.solvd.sql.services;

import com.solvd.sql.interfaces.IOrderDao;
import com.solvd.sql.model.Order;
import com.solvd.sql.mybatis.OrderDao;

import java.util.List;

public class OrderService implements IOrderDao {

    OrderDao orderDao = new OrderDao();

    @Override
    public void insert(Order order) {
        orderDao.insert(order);
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Override
    public void delete(int id) {
        orderDao.delete(id);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public Order getById(int id) {
        return orderDao.getById(id);
    }

    @Override
    public Order getOrderByCustomerName(String name) {
        return orderDao.getOrderByCustomerName(name);
    }
}

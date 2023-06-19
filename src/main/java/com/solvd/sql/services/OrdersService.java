package com.solvd.sql.services;

import com.solvd.sql.interfaces.IOrdersDao;
import com.solvd.sql.model.Orders;
import com.solvd.sql.mybatis.OrdersDao;

import java.util.List;

public class OrdersService implements IOrdersDao {

    OrdersDao ordersDao = new OrdersDao();

    @Override
    public void insert(Orders orders) {
        ordersDao.insert(orders);
    }

    @Override
    public void update(Orders orders) {
        ordersDao.update(orders);
    }

    @Override
    public void delete(int id) {
        ordersDao.delete(id);
    }

    @Override
    public List<Orders> getAll() {
        return ordersDao.getAll();
    }

    @Override
    public Orders getById(int id) {
        return ordersDao.getById(id);
    }

    @Override
    public Orders getByCustomerName(String name) {
        return ordersDao.getByCustomerName(name);
    }
}

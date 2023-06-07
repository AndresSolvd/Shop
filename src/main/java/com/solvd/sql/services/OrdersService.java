package com.solvd.sql.services;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.jdbc.OrdersDao;
import com.solvd.sql.model.Orders;

import java.sql.SQLException;
import java.util.List;

public class OrdersService implements IBaseDAO<Orders> {

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
}

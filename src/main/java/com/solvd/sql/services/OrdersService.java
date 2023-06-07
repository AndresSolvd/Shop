package com.solvd.sql.services;

import com.solvd.sql.interfaces.IOrdersDao;
import com.solvd.sql.jdbc.OrdersDao;
import com.solvd.sql.model.Orders;

import java.sql.SQLException;
import java.util.List;

public class OrdersService implements IOrdersDao {

    OrdersDao ordersDao = new OrdersDao();

    @Override
    public void insert(Orders orders) throws SQLException {
        ordersDao.insert(orders);
    }

    @Override
    public void update(Orders orders) throws SQLException {
        ordersDao.update(orders);
    }

    @Override
    public void delete(int id) throws SQLException {
        ordersDao.delete(id);
    }

    @Override
    public List<Orders> getAll() throws SQLException {
        return ordersDao.getAll();
    }

    @Override
    public Orders get(int id) throws SQLException {
        return ordersDao.get(id);
    }
}

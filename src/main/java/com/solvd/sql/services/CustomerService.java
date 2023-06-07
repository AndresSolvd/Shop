package com.solvd.sql.services;

import com.solvd.sql.interfaces.ICustomerDao;
import com.solvd.sql.jdbc.CustomerDao;
import com.solvd.sql.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerDao {

    CustomerDao customerDao = new CustomerDao();

    @Override
    public void insert(Customer customer) throws SQLException {
        customerDao.insert(customer);
    }

    @Override
    public void update(Customer customer) throws SQLException {
        customerDao.update(customer);
    }

    @Override
    public void delete(int id) throws SQLException {
        customerDao.delete(id);
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        return customerDao.getAll();
    }

    @Override
    public Customer getById(int id) throws SQLException {
        return customerDao.getById(id);
    }
}

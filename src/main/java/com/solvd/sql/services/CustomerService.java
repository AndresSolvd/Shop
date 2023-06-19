package com.solvd.sql.services;

import com.solvd.sql.interfaces.ICustomerDao;
import com.solvd.sql.model.Customer;
import com.solvd.sql.mybatis.CustomerDao;

import java.util.List;

public class CustomerService implements ICustomerDao {

    CustomerDao customerDao = new CustomerDao();

    @Override
    public void insert(Customer customer) {
        customerDao.insert(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void delete(int id) {
        customerDao.delete(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Override
    public Customer getById(int id) {
        return customerDao.getById(id);
    }

    @Override
    public Customer getByName(String name) {
        return customerDao.getByName(name);
    }
}

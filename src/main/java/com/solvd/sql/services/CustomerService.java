package com.solvd.sql.services;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.mybatis.CustomerDao;
import com.solvd.sql.model.Customer;

import java.util.List;

public class CustomerService implements IBaseDAO<Customer> {

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
}

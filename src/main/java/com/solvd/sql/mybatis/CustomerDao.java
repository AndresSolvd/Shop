package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.ICustomerDao;
import com.solvd.sql.model.Customer;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CustomerDao implements ICustomerDao {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Customer customer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDao customerDao = sqlSession.getMapper(ICustomerDao.class);
            customerDao.insert(customer);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Customer customer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDao customerDao = sqlSession.getMapper(ICustomerDao.class);
            customerDao.update(customer);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDao customerDao = sqlSession.getMapper(ICustomerDao.class);
            customerDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDao customerDao = sqlSession.getMapper(ICustomerDao.class);
            customers = customerDao.getAll();
        }
        return customers;
    }

    @Override
    public Customer getById(int id) {
        Customer customer;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDao customerDao = sqlSession.getMapper(ICustomerDao.class);
            customer = customerDao.getById(id);
        }
        return customer;
    }

    @Override
    public Customer getCustomerByName(String name) {
        Customer customer;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDao customerDao = sqlSession.getMapper(ICustomerDao.class);
            customer = customerDao.getCustomerByName(name);
        }
        return customer;
    }
}
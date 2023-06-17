package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.Customer;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CustomerDao implements IBaseDAO<Customer> {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Customer customer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDAO<Customer> baseDAO = sqlSession.getMapper(IBaseDAO.class);
            baseDAO.insert(customer);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Customer customer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDAO<Customer> baseDAO = sqlSession.getMapper(IBaseDAO.class);
            baseDAO.update(customer);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDAO<Customer> baseDAO = sqlSession.getMapper(IBaseDAO.class);
            baseDAO.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDAO<Customer> baseDAO = sqlSession.getMapper(IBaseDAO.class);
            customers = baseDAO.getAll();
        }
        return customers;
    }

    @Override
    public Customer getById(int id) {
        Customer customer;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDAO<Customer> baseDAO = sqlSession.getMapper(IBaseDAO.class);
            customer = baseDAO.getById(id);
        }
        return customer;
    }
}
package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IOrderDao;
import com.solvd.sql.model.Order;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderDao implements IOrderDao {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Order order) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderDao ordersDao = sqlSession.getMapper(IOrderDao.class);
            ordersDao.insert(order);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Order order) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderDao ordersDao = sqlSession.getMapper(IOrderDao.class);
            ordersDao.update(order);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderDao ordersDao = sqlSession.getMapper(IOrderDao.class);
            ordersDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Order> getAll() {
        List<Order> ordersses;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderDao ordersDao = sqlSession.getMapper(IOrderDao.class);
            ordersses = ordersDao.getAll();
        }
        return ordersses;
    }

    @Override
    public Order getById(int id) {
        Order order;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderDao ordersDao = sqlSession.getMapper(IOrderDao.class);
            order = ordersDao.getById(id);
        }
        return order;
    }

    @Override
    public Order getOrderByCustomerName(String name) {
        Order order;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderDao ordersDao = sqlSession.getMapper(IOrderDao.class);
            order = ordersDao.getOrderByCustomerName(name);
        }
        return order;
    }
}

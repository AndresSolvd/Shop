package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IOrdersDao;
import com.solvd.sql.model.Orders;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrdersDao implements IOrdersDao {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Orders orders) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrdersDao ordersDao = sqlSession.getMapper(IOrdersDao.class);
            ordersDao.insert(orders);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Orders orders) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrdersDao ordersDao = sqlSession.getMapper(IOrdersDao.class);
            ordersDao.update(orders);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrdersDao ordersDao = sqlSession.getMapper(IOrdersDao.class);
            ordersDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Orders> getAll() {
        List<Orders> orderss;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrdersDao ordersDao = sqlSession.getMapper(IOrdersDao.class);
            orderss = ordersDao.getAll();
        }
        return orderss;
    }

    @Override
    public Orders getById(int id) {
        Orders orders;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrdersDao ordersDao = sqlSession.getMapper(IOrdersDao.class);
            orders = ordersDao.getById(id);
        }
        return orders;
    }

    @Override
    public Orders getByCustomerName(String name) {
        return null;
    }
}

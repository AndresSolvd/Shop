package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IOrderItemDao;
import com.solvd.sql.model.OrderItem;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderItemDao implements IOrderItemDao {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(OrderItem orderItem) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderItemDao orderItemDao = sqlSession.getMapper(IOrderItemDao.class);
            orderItemDao.insert(orderItem);
            sqlSession.commit();
        }
    }

    @Override
    public void update(OrderItem orderItem) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderItemDao orderItemDao = sqlSession.getMapper(IOrderItemDao.class);
            orderItemDao.update(orderItem);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderItemDao orderItemDao = sqlSession.getMapper(IOrderItemDao.class);
            orderItemDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<OrderItem> getAll() {
        List<OrderItem> orderItems;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderItemDao orderItemDao = sqlSession.getMapper(IOrderItemDao.class);
            orderItems = orderItemDao.getAll();
        }
        return orderItems;
    }

    @Override
    public OrderItem getById(int id) {
        OrderItem orderItem;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderItemDao orderItemDao = sqlSession.getMapper(IOrderItemDao.class);
            orderItem = orderItemDao.getById(id);
        }
        return orderItem;
    }
}
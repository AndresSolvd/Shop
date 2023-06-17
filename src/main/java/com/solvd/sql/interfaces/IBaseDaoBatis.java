package com.solvd.sql.interfaces;

import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface IBaseDaoBatis<T> {

    SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    // CRUD Create
    default void insert(T t) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDaoBatis iBaseDaoBatis = sqlSession.getMapper(IBaseDaoBatis.class);
            iBaseDaoBatis.insert(t);
            sqlSession.commit();
        }
    }

    // CRUD Update
    default void update(T t) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDaoBatis iBaseDaoBatis = sqlSession.getMapper(IBaseDaoBatis.class);
            iBaseDaoBatis.update(t);
            sqlSession.commit();
        }
    }

    // CRUD Delete
    default void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDaoBatis iBaseDaoBatis = sqlSession.getMapper(IBaseDaoBatis.class);
            iBaseDaoBatis.delete(id);
            sqlSession.commit();
        }
    }

    // Get All
    default List<T> getAll() {
        List<T> ts;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDaoBatis iBaseDaoBatis = sqlSession.getMapper(IBaseDaoBatis.class);
            ts = iBaseDaoBatis.getAll();
        }
        return ts;
    }

    // CRUD Read
    default T getById(int id) {
        T t;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDaoBatis iBaseDaoBatis = sqlSession.getMapper(IBaseDaoBatis.class);
            t = (T) iBaseDaoBatis.getById(id);
        }
        return t;
    }
}

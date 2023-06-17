package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IOwnerDao;
import com.solvd.sql.model.Owner;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OwnerDao implements IOwnerDao {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Owner owner) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOwnerDao ownerDao = sqlSession.getMapper(IOwnerDao.class);
            ownerDao.insert(owner);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Owner owner) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOwnerDao ownerDao = sqlSession.getMapper(IOwnerDao.class);
            ownerDao.update(owner);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOwnerDao ownerDao = sqlSession.getMapper(IOwnerDao.class);
            ownerDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Owner> getAll() {
        List<Owner> owners;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOwnerDao ownerDao = sqlSession.getMapper(IOwnerDao.class);
            owners = ownerDao.getAll();
        }
        return owners;
    }

    @Override
    public Owner getById(int id) {
        Owner owner;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOwnerDao ownerDao = sqlSession.getMapper(IOwnerDao.class);
            owner = ownerDao.getById(id);
        }
        return owner;
    }
}

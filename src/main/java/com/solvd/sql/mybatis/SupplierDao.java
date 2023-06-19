package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.ISupplierDao;
import com.solvd.sql.model.Supplier;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SupplierDao implements ISupplierDao {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Supplier supplier) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDao supplierDao = sqlSession.getMapper(ISupplierDao.class);
            supplierDao.insert(supplier);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Supplier supplier) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDao supplierDao = sqlSession.getMapper(ISupplierDao.class);
            supplierDao.update(supplier);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDao supplierDao = sqlSession.getMapper(ISupplierDao.class);
            supplierDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Supplier> getAll() {
        List<Supplier> suppliers;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDao supplierDao = sqlSession.getMapper(ISupplierDao.class);
            suppliers = supplierDao.getAll();
        }
        return suppliers;
    }

    @Override
    public Supplier getById(int id) {
        Supplier supplier;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDao supplierDao = sqlSession.getMapper(ISupplierDao.class);
            supplier = supplierDao.getById(id);
        }
        return supplier;
    }

    @Override
    public Supplier getByName(String name) {
        Supplier supplier;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDao supplierDao = sqlSession.getMapper(ISupplierDao.class);
            supplier = supplierDao.getByName(name);
        }
        return supplier;
    }
}

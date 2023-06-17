package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.interfaces.IProductDao;
import com.solvd.sql.model.Product;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProductDao implements IBaseDAO<Product> {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Product product) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProductDao productDao = sqlSession.getMapper(IProductDao.class);
            productDao.insert(product);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Product product) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProductDao productDao = sqlSession.getMapper(IProductDao.class);
            productDao.update(product);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProductDao productDao = sqlSession.getMapper(IProductDao.class);
            productDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProductDao productDao = sqlSession.getMapper(IProductDao.class);
            products = productDao.getAll();
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        Product product;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProductDao productDao = sqlSession.getMapper(IProductDao.class);
            product = productDao.getById(id);
        }
        return product;
    }
}

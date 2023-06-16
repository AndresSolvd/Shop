package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.ICategoryDao;
import com.solvd.sql.model.Category;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CategoryDao implements ICategoryDao {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Category category) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDao categoryDao = sqlSession.getMapper(ICategoryDao.class);
            categoryDao.insert(category);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Category category) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDao categoryDao = sqlSession.getMapper(ICategoryDao.class);
            categoryDao.update(category);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDao categoryDao = sqlSession.getMapper(ICategoryDao.class);
            categoryDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDao categoryDao = sqlSession.getMapper(ICategoryDao.class);
            categories = categoryDao.getAll();
        }
        return categories;
    }

    @Override
    public Category getById(int id) {
        Category category;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDao categoryDao = sqlSession.getMapper(ICategoryDao.class);
            category = categoryDao.getById(id);
        }
        return category;
    }

    @Override
    public Category getByName(String categoryName) {
        Category category;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDao categoryDao = sqlSession.getMapper(ICategoryDao.class);
            category = categoryDao.getByName(categoryName);
        }
        return category;
    }
}
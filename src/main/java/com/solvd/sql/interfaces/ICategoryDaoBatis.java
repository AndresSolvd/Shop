package com.solvd.sql.interfaces;

import com.solvd.sql.model.Category;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface ICategoryDaoBatis {

    SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    // CRUD Create
    default void insert(Category category) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDaoBatis iCategoryDaoBatis = sqlSession.getMapper(ICategoryDaoBatis.class);
            iCategoryDaoBatis.insert(category);
            sqlSession.commit();
        }
    }

    // CRUD Update
    default void update(Category category) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDaoBatis iCategoryDaoBatis = sqlSession.getMapper(ICategoryDaoBatis.class);
            iCategoryDaoBatis.update(category);
            sqlSession.commit();
        }
    }

    // CRUD Delete
    default void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDaoBatis iCategoryDaoBatis = sqlSession.getMapper(ICategoryDaoBatis.class);
            iCategoryDaoBatis.delete(id);
            sqlSession.commit();
        }
    }

    // Get All
    default List<Category> getAll() {
        List<Category> categories;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDaoBatis iCategoryDaoBatis = sqlSession.getMapper(ICategoryDaoBatis.class);
            categories = iCategoryDaoBatis.getAll();
        }
        return categories;
    }

    // CRUD Read
    default Category getById(int id) {
        Category category;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDaoBatis iCategoryDaoBatis = sqlSession.getMapper(ICategoryDaoBatis.class);
            category = iCategoryDaoBatis.getById(id);
        }
        return category;
    }

    Category getByName(String categoryName);
}

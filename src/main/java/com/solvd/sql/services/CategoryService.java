package com.solvd.sql.services;

import com.solvd.sql.interfaces.ICategoryDao;
import com.solvd.sql.jdbc.CategoryDao;
import com.solvd.sql.model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryDao {

    CategoryDao categoryDao = new CategoryDao();

    @Override
    public void insert(Category category) throws SQLException {
        categoryDao.insert(category);
    }

    @Override
    public void update(Category category) throws SQLException {
        categoryDao.update(category);
    }

    @Override
    public void delete(int id) throws SQLException {
        categoryDao.delete(id);
    }

    @Override
    public List<Category> getAll() throws SQLException {
        return categoryDao.getAll();
    }

    @Override
    public Category get(int id) throws SQLException {
        return categoryDao.get(id);
    }

    @Override
    public Category get(String categoryName) throws SQLException {
        return categoryDao.get(categoryName);
    }
}

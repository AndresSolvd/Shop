package com.solvd.sql.services;

import com.solvd.sql.interfaces.ICategoryDao;
import com.solvd.sql.mybatis.CategoryDao;
import com.solvd.sql.model.Category;

import java.util.List;

public class CategoryService implements ICategoryDao {

    CategoryDao categoryDao = new CategoryDao();

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public Category getById(int id) {
        return categoryDao.getById(id);
    }

    @Override
    public Category getByName(String categoryName) {
        return categoryDao.getByName(categoryName);
    }
}

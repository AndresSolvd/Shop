package com.solvd;

import com.solvd.sql.interfaces.ICategoryDao;
import com.solvd.sql.model.Category;
import com.solvd.sql.mybatis.CategoryDao;

public class MyBatisMain {
    public static void main(String[] args) {
        // test
        System.out.println(new CategoryDao().getById(1));
        // Insert
        Category category = new Category();
        category.setCategoryName("plants");
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.insert(category);
        // Print by id
        System.out.println(new CategoryDao().getById(1));
        // Print by name
        System.out.println(new CategoryDao().getByName("plants")); // Empty DB as repeated categories throw error
        // Print all
        System.out.println(new CategoryDao().getAll());
        // Update
        category.setCategoryName("Candies");
        new CategoryDao().update(category);
        System.out.println(new CategoryDao().getById(1));
        // Delete
        new CategoryDao().delete(1);
        System.out.println(new CategoryDao().getById(1));
    }
}

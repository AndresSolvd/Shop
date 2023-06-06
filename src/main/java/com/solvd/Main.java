package com.solvd;

import com.solvd.sql.jdbc.CategoryDao;
import com.solvd.sql.model.Category;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        // CATEGORY
        // Create
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category();
        category.setCategoryName("The test Discount");
        categoryDao.insert(category);
        category.setCategoryName("Another test Discount");
        categoryDao.insert(category);
        // Update
        category.setCategoryName("Update Discount"); // Needs to specify the ID
        category.setId(3);
        categoryDao.update(category);
        // Delete
        categoryDao.delete(2);
        // Read
        System.out.println(categoryDao.get(1));
        System.out.println(categoryDao.get("Update Discount")); // If repeated name select the last.
        System.out.println(categoryDao.get("The Test Discount")); // If repeated name select the last.
        // All
        System.out.println(categoryDao.getAll());
    }
}

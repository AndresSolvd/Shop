package com.solvd.sql.interfaces;

import com.solvd.sql.model.Category;

import java.sql.SQLException;

public interface IDaoCategory extends IDao<Category>{
    Category get(String categoryName) throws SQLException;
}
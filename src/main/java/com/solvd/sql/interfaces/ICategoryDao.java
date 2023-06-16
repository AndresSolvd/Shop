package com.solvd.sql.interfaces;

import com.solvd.sql.model.Category;

public interface ICategoryDao extends IBaseDAO<Category> {
    Category getByName(String categoryName);
}

package com.solvd.sql.builder;

import com.solvd.sql.model.Category;

public class CategoryBuilder {
    private int id;
    private String categoryName;

    private CategoryBuilder() {
    }

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public CategoryBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public CategoryBuilder withCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public Category build() {
        Category category = new Category();
        category.setId(this.id);
        category.setCategoryName(this.categoryName);
        return category;
    }
}

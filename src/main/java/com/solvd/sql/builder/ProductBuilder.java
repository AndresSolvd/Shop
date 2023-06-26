package com.solvd.sql.builder;

import com.solvd.sql.model.Category;
import com.solvd.sql.model.Product;
import com.solvd.sql.model.Supplier;

public class ProductBuilder {
    private int id;
    private String productName;
    private int stock;
    private double price;
    private Category category;
    private Supplier supplier;

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public ProductBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductBuilder withStock(int stock) {
        this.stock = stock;
        return this;
    }

    public ProductBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public ProductBuilder withSupplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    public Product build() {
        Product product = new Product();
        product.setId(this.id);
        product.setProductName(this.productName);
        product.setStock(this.stock);
        product.setPrice(this.price);
        product.setCategory(this.category);
        product.setSupplier(this.supplier);
        return product;
    }
}

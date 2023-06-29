package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "product")
@JsonRootName("product")
public class Product {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "productName")
    @JsonProperty("productName")
    private String productName;

    @XmlElement(name = "stock")
    @JsonProperty("stock")
    private int stock;

    @XmlElement(name = "price")
    @JsonProperty("price")
    private double price;

    @XmlElement(name = "category", type = Category.class)
    @JsonProperty("category")
    private Category category;

    @XmlElement(name = "supplier", type = Supplier.class)
    @JsonProperty("supplier")
    private Supplier supplier;

    // Private constructor for the builder
    private Product(Builder builder) {
        this.id = builder.id;
        this.productName = builder.productName;
        this.stock = builder.stock;
        this.price = builder.price;
        this.category = builder.category;
        this.supplier = builder.supplier;
    }

    // Private default constructor for MyBatis
    private Product() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", category=" + category +
                ", supplier=" + supplier +
                '}';
    }

    // Inner Builder class
    public static class Builder {
        private int id;
        private String productName;
        private int stock;
        private double price;
        private Category category;
        private Supplier supplier;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder withStock(int stock) {
            this.stock = stock;
            return this;
        }

        public Builder withPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder withSupplier(Supplier supplier) {
            this.supplier = supplier;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
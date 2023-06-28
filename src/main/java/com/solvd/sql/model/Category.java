package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "category")
@JsonRootName(value = "category")
public class Category {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "categoryName")
    @JsonProperty("categoryName")
    private String categoryName;

    //constructor
    private Category(Builder builder) {
        this.id = builder.id;
        this.categoryName = builder.categoryName;
    }

    // Constructor for MyBatis
    private Category() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    // Inner Builder Class
    public static class Builder {
        private int id;
        private String categoryName;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
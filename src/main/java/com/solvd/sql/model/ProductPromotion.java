package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "productPromotion")
@JsonRootName(value = "productPromotion")
public class ProductPromotion {

    @XmlElement(name = "promotion", type = Promotion.class)
    @JsonProperty("promotion")
    private Promotion promotion;

    @XmlElement(name = "product", type = Product.class)
    @JsonProperty("product")
    private Product product;

    // Private constructor for the builder
    private ProductPromotion(Builder builder) {
        this.promotion = builder.promotion;
        this.product = builder.product;
    }

    // Private default constructor for MyBatis
    private ProductPromotion() {
    }

    // Getters and Setters
    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPromotion{" +
                "promotion=" + promotion +
                ", product=" + product +
                '}';
    }

    // Inner Builder class
    public static class Builder {
        private Promotion promotion;
        private Product product;

        public Builder withPromotion(Promotion promotion) {
            this.promotion = promotion;
            return this;
        }

        public Builder withProduct(Product product) {
            this.product = product;
            return this;
        }

        public ProductPromotion build() {
            return new ProductPromotion(this);
        }
    }
}
package com.solvd.sql.builder;

import com.solvd.sql.model.Product;
import com.solvd.sql.model.ProductPromotion;
import com.solvd.sql.model.Promotion;

public class ProductPromotionBuilder {
    private Promotion promotion;
    private Product product;

    public static ProductPromotionBuilder builder() {
        return new ProductPromotionBuilder();
    }

    public ProductPromotionBuilder withPromotion(Promotion promotion) {
        this.promotion = promotion;
        return this;
    }

    public ProductPromotionBuilder withProduct(Product product) {
        this.product = product;
        return this;
    }

    public ProductPromotion build() {
        ProductPromotion productPromotion = new ProductPromotion();
        productPromotion.setPromotion(this.promotion);
        productPromotion.setProduct(this.product);
        return productPromotion;
    }
}

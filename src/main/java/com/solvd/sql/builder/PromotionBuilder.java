package com.solvd.sql.builder;

import com.solvd.sql.model.Promotion;

import java.sql.Date;

public class PromotionBuilder {
    private int id;
    private String promotionName;
    private float discount;
    private Date startDate;
    private Date endDate;

    public static PromotionBuilder builder() {
        return new PromotionBuilder();
    }

    public PromotionBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public PromotionBuilder withPromotionName(String promotionName) {
        this.promotionName = promotionName;
        return this;
    }

    public PromotionBuilder withDiscount(float discount) {
        this.discount = discount;
        return this;
    }

    public PromotionBuilder withStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public PromotionBuilder withEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Promotion build() {
        Promotion promotion = new Promotion();
        promotion.setId(this.id);
        promotion.setPromotionName(this.promotionName);
        promotion.setDiscount(this.discount);
        promotion.setStartDate(this.startDate);
        promotion.setEndDate(this.endDate);
        return promotion;
    }
}
package com.solvd.sql.model;

public class ProductPromotion {
    private int promotionId;
    private int productId;

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductPromotion{" +
                "promotionId=" + promotionId +
                ", productId=" + productId +
                '}';
    }
}

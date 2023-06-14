package com.solvd.sql.model;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "productPromotion")
@JsonRootName(value = "productPromotion")
public class ProductPromotion {

    @XmlElement(name = "promotionId")
    @JsonProperty("promotionId")
    private int promotionId;

    @XmlElement(name = "productId")
    @JsonProperty("productId")
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

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
}

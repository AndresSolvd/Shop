package com.solvd.sql.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.sql.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "promotion")
@JsonRootName("promotion")
public class Promotion {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private int id;

    @XmlElement(name = "promotionName")
    @JsonProperty("promotionName")
    private String promotionName;

    @XmlElement(name = "discount")
    @JsonProperty("discount")
    private float discount;

    @XmlElement(name = "startDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("startDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;

    @XmlElement(name = "endDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("endDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

    // Private constructor for the builder
    private Promotion(Builder builder) {
        this.id = builder.id;
        this.promotionName = builder.promotionName;
        this.discount = builder.discount;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    // Private default constructor for MyBatis
    private Promotion() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", promotionName='" + promotionName + '\'' +
                ", discount=" + discount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    // Inner Builder class
    public static class Builder {
        private int id;
        private String promotionName;
        private float discount;
        private Date startDate;
        private Date endDate;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withPromotionName(String promotionName) {
            this.promotionName = promotionName;
            return this;
        }

        public Builder withDiscount(float discount) {
            this.discount = discount;
            return this;
        }

        public Builder withStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Promotion build() {
            return new Promotion(this);
        }
    }
}
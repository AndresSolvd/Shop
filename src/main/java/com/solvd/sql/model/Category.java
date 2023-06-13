package com.solvd.sql.model;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.*;

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
}

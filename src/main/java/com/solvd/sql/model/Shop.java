package com.solvd.sql.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "shop")
public class Shop {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "shopName")
    private String shopName;

    @XmlElement(name = "address")
    private String address;

    @XmlElement(name = "phone")
    private String phone;

    @XmlElement(name = "ownerId")
    private int ownerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }
}

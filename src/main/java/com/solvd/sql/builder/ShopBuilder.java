package com.solvd.sql.builder;

import com.solvd.sql.model.Owner;
import com.solvd.sql.model.Shop;

public class ShopBuilder {
    private int id;
    private String shopName;
    private String address;
    private String phone;
    private Owner owner;

    public static ShopBuilder builder() {
        return new ShopBuilder();
    }

    public ShopBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public ShopBuilder withShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    public ShopBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public ShopBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ShopBuilder withOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public Shop build() {
        Shop shop = new Shop();
        shop.setId(this.id);
        shop.setShopName(this.shopName);
        shop.setAddress(this.address);
        shop.setPhone(this.phone);
        shop.setOwner(this.owner);
        return shop;
    }
}

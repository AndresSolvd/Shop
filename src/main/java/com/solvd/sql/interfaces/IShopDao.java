package com.solvd.sql.interfaces;

import com.solvd.sql.model.Shop;

public interface IShopDao extends IBaseDAO<Shop> {

    Shop getShopByName(String name);
}

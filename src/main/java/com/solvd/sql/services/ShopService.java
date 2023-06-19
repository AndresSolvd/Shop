package com.solvd.sql.services;

import com.solvd.sql.interfaces.IShopDao;
import com.solvd.sql.model.Shop;
import com.solvd.sql.mybatis.ShopDao;

import java.util.List;

public class ShopService implements IShopDao {

    ShopDao shopDao = new ShopDao();

    @Override
    public void insert(Shop shop) {
        shopDao.insert(shop);
    }

    @Override
    public void update(Shop shop) {
        shopDao.update(shop);
    }

    @Override
    public void delete(int id) {
        shopDao.delete(id);
    }

    @Override
    public List<Shop> getAll() {
        return shopDao.getAll();
    }

    @Override
    public Shop getById(int id) {
        return shopDao.getById(id);
    }

    @Override
    public Shop getByName(String name) {
        return shopDao.getByName(name);
    }
}

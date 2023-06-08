package com.solvd.sql.services;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.jdbc.ShopDao;
import com.solvd.sql.model.Shop;

import java.util.List;

public class ShopService implements IBaseDAO<Shop> {

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
}

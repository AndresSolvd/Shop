package com.solvd.sql.services;

import com.solvd.sql.interfaces.IShopDao;
import com.solvd.sql.jdbc.ShopDao;
import com.solvd.sql.model.Shop;

import java.sql.SQLException;
import java.util.List;

public class ShopService implements IShopDao {

    ShopDao shopDao = new ShopDao();

    @Override
    public void insert(Shop shop) throws SQLException {
        shopDao.insert(shop);
    }

    @Override
    public void update(Shop shop) throws SQLException {
        shopDao.update(shop);
    }

    @Override
    public void delete(int id) throws SQLException {
        shopDao.delete(id);
    }

    @Override
    public List<Shop> getAll() throws SQLException {
        return shopDao.getAll();
    }

    @Override
    public Shop getById(int id) throws SQLException {
        return shopDao.getById(id);
    }
}

package com.solvd.sql.services;

import com.solvd.sql.interfaces.IProductPromotionDao;
import com.solvd.sql.jdbc.ProductPromotionDao;
import com.solvd.sql.model.ProductPromotion;

import java.sql.SQLException;
import java.util.List;

public class ProductPromotionService implements IProductPromotionDao {

    ProductPromotionDao promotionDao = new ProductPromotionDao();

    @Override
    public void insert(ProductPromotion productPromotion) throws SQLException {
        promotionDao.insert(productPromotion);
    }

    @Override
    public void update(ProductPromotion productPromotion) throws SQLException {
        promotionDao.update(productPromotion);
    }

    @Override
    public void delete(int id) throws SQLException {
        promotionDao.delete(id);
    }

    @Override
    public List<ProductPromotion> getAll() throws SQLException {
        return promotionDao.getAll();
    }

    @Override
    public ProductPromotion get(int id) throws SQLException {
        return promotionDao.get(id);
    }
}

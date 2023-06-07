package com.solvd.sql.services;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.jdbc.ProductPromotionDao;
import com.solvd.sql.model.ProductPromotion;

import java.util.List;

public class ProductPromotionService implements IBaseDAO<ProductPromotion> {

    ProductPromotionDao promotionDao = new ProductPromotionDao();

    @Override
    public void insert(ProductPromotion productPromotion) {
        promotionDao.insert(productPromotion);
    }

    @Override
    public void update(ProductPromotion productPromotion) {
        promotionDao.update(productPromotion);
    }

    @Override
    public void delete(int id) {
        promotionDao.delete(id);
    }

    @Override
    public List<ProductPromotion> getAll() {
        return promotionDao.getAll();
    }

    @Override
    public ProductPromotion getById(int id) {
        return promotionDao.getById(id);
    }
}

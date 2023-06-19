package com.solvd.sql.services;

import com.solvd.sql.interfaces.IProductPromotionDao;
import com.solvd.sql.model.ProductPromotion;
import com.solvd.sql.mybatis.ProductPromotionDao;

import java.util.List;

public class ProductPromotionService implements IProductPromotionDao {

    ProductPromotionDao productPromotionDao = new ProductPromotionDao();

    @Override
    public void insert(ProductPromotion productPromotion) {
        productPromotionDao.insert(productPromotion);
    }

    @Override
    public void update(ProductPromotion productPromotion) {
        productPromotionDao.update(productPromotion);
    }

    @Override
    public void delete(int id) {
        productPromotionDao.delete(id);
    }

    @Override
    public List<ProductPromotion> getAll() {
        return productPromotionDao.getAll();
    }

    @Override
    public ProductPromotion getById(int id) {
        return productPromotionDao.getById(id);
    }

    @Override
    public ProductPromotion getByProductName(String productName) {
        return productPromotionDao.getByProductName(productName);
    }
}

package com.solvd.sql.services;

import com.solvd.sql.interfaces.IPromotionDao;
import com.solvd.sql.model.Promotion;
import com.solvd.sql.mybatis.PromotionDao;

import java.util.List;

public class PromotionService implements IPromotionDao {

    PromotionDao promotionDao = new PromotionDao();

    @Override
    public void insert(Promotion promotion) {
        promotionDao.insert(promotion);
    }

    @Override
    public void update(Promotion promotion) {
        promotionDao.update(promotion);
    }

    @Override
    public void delete(int id) {
        promotionDao.delete(id);
    }

    @Override
    public List<Promotion> getAll() {
        return promotionDao.getAll();
    }

    @Override
    public Promotion getById(int id) {
        return promotionDao.getById(id);
    }

    @Override
    public Promotion getByName(String name) {
        return promotionDao.getByName(name);
    }
}

package com.solvd.sql.services;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.jdbc.PromotionDao;
import com.solvd.sql.model.Promotion;

import java.sql.SQLException;
import java.util.List;

public class PromotionService implements IBaseDAO<Promotion> {

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
}

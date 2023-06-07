package com.solvd.sql.services;

import com.solvd.sql.interfaces.IPromotionDao;
import com.solvd.sql.jdbc.PromotionDao;
import com.solvd.sql.model.Promotion;

import java.sql.SQLException;
import java.util.List;

public class PromotionService implements IPromotionDao {

    PromotionDao promotionDao = new PromotionDao();

    @Override
    public void insert(Promotion promotion) throws SQLException {
        promotionDao.insert(promotion);
    }

    @Override
    public void update(Promotion promotion) throws SQLException {
        promotionDao.update(promotion);
    }

    @Override
    public void delete(int id) throws SQLException {
        promotionDao.delete(id);
    }

    @Override
    public List<Promotion> getAll() throws SQLException {
        return promotionDao.getAll();
    }

    @Override
    public Promotion getById(int id) throws SQLException {
        return promotionDao.getById(id);
    }
}

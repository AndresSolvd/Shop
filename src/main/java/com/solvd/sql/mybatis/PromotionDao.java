package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IPromotionDao;
import com.solvd.sql.model.Promotion;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PromotionDao implements IPromotionDao {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Promotion promotion) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPromotionDao promotionDao = sqlSession.getMapper(IPromotionDao.class);
            promotionDao.insert(promotion);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Promotion promotion) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPromotionDao promotionDao = sqlSession.getMapper(IPromotionDao.class);
            promotionDao.update(promotion);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPromotionDao promotionDao = sqlSession.getMapper(IPromotionDao.class);
            promotionDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Promotion> getAll() {
        List<Promotion> promotions;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPromotionDao promotionDao = sqlSession.getMapper(IPromotionDao.class);
            promotions = promotionDao.getAll();
        }
        return promotions;
    }

    @Override
    public Promotion getById(int id) {
        Promotion promotion;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPromotionDao promotionDao = sqlSession.getMapper(IPromotionDao.class);
            promotion = promotionDao.getById(id);
        }
        return promotion;
    }

    @Override
    public Promotion getPromotionByName(String name) {
        Promotion promotion;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPromotionDao promotionDao = sqlSession.getMapper(IPromotionDao.class);
            promotion = promotionDao.getPromotionByName(name);
        }
        return promotion;
    }
}
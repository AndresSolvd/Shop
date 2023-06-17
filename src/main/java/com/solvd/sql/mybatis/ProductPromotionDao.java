package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.interfaces.IProductPromotionDao;
import com.solvd.sql.model.ProductPromotion;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProductPromotionDao implements IBaseDAO<ProductPromotion> {


    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(ProductPromotion productPromotion) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProductPromotionDao productPromotionDao = sqlSession.getMapper(IProductPromotionDao.class);
            productPromotionDao.insert(productPromotion);
            sqlSession.commit();
        }
    }

    @Override
    public void update(ProductPromotion productPromotion) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProductPromotionDao productPromotionDao = sqlSession.getMapper(IProductPromotionDao.class);
            productPromotionDao.update(productPromotion);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProductPromotionDao productPromotionDao = sqlSession.getMapper(IProductPromotionDao.class);
            productPromotionDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<ProductPromotion> getAll() {
        List<ProductPromotion> productPromotions;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProductPromotionDao productPromotionDao = sqlSession.getMapper(IProductPromotionDao.class);
            productPromotions = productPromotionDao.getAll();
        }
        return productPromotions;
    }

    @Override
    public ProductPromotion getById(int id) {
        ProductPromotion productPromotion;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProductPromotionDao productPromotionDao = sqlSession.getMapper(IProductPromotionDao.class);
            productPromotion = productPromotionDao.getById(id);
        }
        return productPromotion;
    }
}

package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IShopDao;
import com.solvd.sql.model.Shop;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ShopDao implements IShopDao {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Shop shop) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IShopDao shopDao = sqlSession.getMapper(IShopDao.class);
            shopDao.insert(shop);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Shop shop) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IShopDao shopDao = sqlSession.getMapper(IShopDao.class);
            shopDao.update(shop);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IShopDao shopDao = sqlSession.getMapper(IShopDao.class);
            shopDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Shop> getAll() {
        List<Shop> shops;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IShopDao shopDao = sqlSession.getMapper(IShopDao.class);
            shops = shopDao.getAll();
        }
        return shops;
    }

    @Override
    public Shop getById(int id) {
        Shop shop;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IShopDao shopDao = sqlSession.getMapper(IShopDao.class);
            shop = shopDao.getById(id);
        }
        return shop;
    }

    @Override
    public Shop getByName(String name) {
        Shop shop;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IShopDao shopDao = sqlSession.getMapper(IShopDao.class);
            shop = shopDao.getByName(name);
        }
        return shop;
    }
}

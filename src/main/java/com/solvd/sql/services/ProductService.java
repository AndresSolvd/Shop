package com.solvd.sql.services;

import com.solvd.sql.interfaces.IProductDao;
import com.solvd.sql.model.Product;
import com.solvd.sql.mybatis.ProductDao;

import java.util.List;

public class ProductService implements IProductDao {

    ProductDao productDao = new ProductDao();

    @Override
    public void insert(Product product) {
        productDao.insert(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product getById(int id) {
        return productDao.getById(id);
    }

    @Override
    public Product getProductByName(String name) {
        return productDao.getProductByName(name);
    }
}

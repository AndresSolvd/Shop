package com.solvd.sql.services;

import com.solvd.sql.interfaces.IProductDao;
import com.solvd.sql.jdbc.ProductDao;
import com.solvd.sql.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductDao {

    ProductDao productDao = new ProductDao();

    @Override
    public void insert(Product product) throws SQLException {
        productDao.insert(product);
    }

    @Override
    public void update(Product product) throws SQLException {
        productDao.update(product);
    }

    @Override
    public void delete(int id) throws SQLException {
        productDao.delete(id);
    }

    @Override
    public List<Product> getAll() throws SQLException {
        return productDao.getAll();
    }

    @Override
    public Product get(int id) throws SQLException {
        return productDao.get(id);
    }
}

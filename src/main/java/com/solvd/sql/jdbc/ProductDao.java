package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.Product;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IBaseDAO<Product> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Product product) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO product (product_name, stock, price, category_id, supplier_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getStock());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getCategoryId());
            ps.setInt(5, product.getSupplierId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    connectionPool.releaseConnection(con);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void update(Product product) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE product SET product_name = ?, stock = ?, price = ?, category_id = ?, supplier_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getStock());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getCategoryId());
            ps.setInt(5, product.getSupplierId());
            ps.setInt(6, product.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            try {
                connectionPool.releaseConnection(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM product WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connectionPool.releaseConnection(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Product> getAll() {
        Connection con = connectionPool.getConnection();
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setStock(rs.getInt("stock"));
                    product.setPrice(rs.getDouble("price"));
                    product.setCategoryId(rs.getInt("category_id"));
                    product.setSupplierId(rs.getInt("supplier_id"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connectionPool.releaseConnection(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        Connection con = connectionPool.getConnection();
        Product product = new Product();
        String query = "SELECT * FROM product WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    product.setId(rs.getInt("id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setStock(rs.getInt("stock"));
                    product.setPrice(rs.getDouble("price"));
                    product.setCategoryId(rs.getInt("category_id"));
                    product.setSupplierId(rs.getInt("supplier_id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                try {
                    connectionPool.releaseConnection(con);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}

package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.ProductPromotion;
import com.solvd.util.ConnectionPool;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ProductPromotionDao")
public class ProductPromotionDao implements IBaseDAO<ProductPromotion> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(ProductPromotion productPromotion) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO product_promotion (promotion_id, product_id) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, productPromotion.getPromotionId());
            ps.setInt(2, productPromotion.getProductId());
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
    public void update(ProductPromotion productPromotion) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE product_promotion SET promotion_id = ? WHERE product_id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, productPromotion.getPromotionId());
            ps.setInt(2, productPromotion.getProductId());
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
        String query = "DELETE FROM product_promotion WHERE promotion_id = ?";
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
    public List<ProductPromotion> getAll() {
        Connection con = connectionPool.getConnection();
        List<ProductPromotion> productPromotions = new ArrayList<>();
        String query = "SELECT * FROM product_promotion";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    ProductPromotion productPromotion = new ProductPromotion();
                    productPromotion.setPromotionId(rs.getInt("promotion_id"));
                    productPromotion.setProductId(rs.getInt("product_id"));
                    productPromotions.add(productPromotion);
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
        return productPromotions;
    }

    @Override
    public ProductPromotion getById(int id) {
        Connection con = connectionPool.getConnection();
        ProductPromotion productPromotion = new ProductPromotion();
        String query = "SELECT * FROM product_promotion WHERE product_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    productPromotion.setPromotionId(rs.getInt("promotion_id"));
                    productPromotion.setProductId(rs.getInt("product_id"));
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
        return productPromotion;
    }
}

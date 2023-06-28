package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.Promotion;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotionDao implements IBaseDAO<Promotion> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Promotion promotion) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO promotion (promotion_name, discount, start_date, end_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, promotion.getPromotionName());
            ps.setFloat(2, promotion.getDiscount());
            ps.setDate(3, promotion.getStartDate());
            ps.setDate(4, promotion.getEndDate());
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
    public void update(Promotion promotion) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE promotion SET promotion_name = ?, discount = ?, start_date = ?, end_date = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, promotion.getPromotionName());
            ps.setFloat(2, promotion.getDiscount());
            ps.setDate(3, promotion.getStartDate());
            ps.setDate(4, promotion.getEndDate());
            ps.setInt(5, promotion.getId());
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
        String query = "DELETE FROM promotion WHERE id = ?";
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
    public List<Promotion> getAll() {
        Connection con = connectionPool.getConnection();
        List<Promotion> promotions = new ArrayList<>();
        String query = "SELECT * FROM promotion";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    promotions.add(new Promotion.Builder()
                            .withId(rs.getInt("id"))
                            .withPromotionName(rs.getString("promotion_name"))
                            .withDiscount(rs.getFloat("discount"))
                            .withStartDate(rs.getDate("start_date"))
                            .withEndDate(rs.getDate("end_date"))
                            .build());
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
        return promotions;
    }

    @Override
    public Promotion getById(int id) {
        Connection con = connectionPool.getConnection();
        String query = "SELECT * FROM promotion WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                return new Promotion.Builder()
                        .withId(rs.getInt("id"))
                        .withPromotionName(rs.getString("promotion_name"))
                        .withDiscount(rs.getFloat("discount"))
                        .withStartDate(rs.getDate("start_date"))
                        .withEndDate(rs.getDate("end_date"))
                        .build();

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
    }
}
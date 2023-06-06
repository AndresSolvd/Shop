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
    public void insert(Promotion promotion) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO promotion (promotion_name, discount, start_date, end_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, promotion.getPromotionName());
            ps.setFloat(4, promotion.getDiscount());
            ps.setDate(3, promotion.getStartDate());
            ps.setDate(4, promotion.getStartDate());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                connectionPool.releaseConnection(con);
            }
        }
    }

    @Override
    public void update(Promotion promotion) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE promotion SET promotion_name = ?, discount = ?, start_date = ?, end_date = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, promotion.getPromotionName());
            ps.setFloat(4, promotion.getDiscount());
            ps.setDate(3, promotion.getStartDate());
            ps.setDate(4, promotion.getStartDate());
            ps.setInt(5, promotion.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            connectionPool.releaseConnection(con);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM promotion WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(con);
        }
    }

    @Override
    public List<Promotion> getAll() throws SQLException {
        Connection con = connectionPool.getConnection();
        List<Promotion> promotions = new ArrayList<>();
        String query = "SELECT * FROM promotion";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Promotion promotion = new Promotion();
                    promotion.setId(rs.getInt("id"));
                    promotion.setPromotionName(rs.getString("promotion_name"));
                    promotion.setDiscount(rs.getFloat("discount"));
                    promotion.setStartDate(rs.getDate("start_date"));
                    promotion.setEndDate(rs.getDate("end_date"));
                    promotions.add(promotion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(con);
        }
        return promotions;
    }

    @Override
    public Promotion get(int id) throws SQLException {
        Connection con = connectionPool.getConnection();
        Promotion promotion = new Promotion();
        String query = "SELECT * FROM promotion WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    promotion.setId(rs.getInt("id"));
                    promotion.setPromotionName(rs.getString("promotion_name"));
                    promotion.setDiscount(rs.getFloat("discount"));
                    promotion.setStartDate(rs.getDate("start_date"));
                    promotion.setEndDate(rs.getDate("end_date"));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        }
        return promotion;
    }
}

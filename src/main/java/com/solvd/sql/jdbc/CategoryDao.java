package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IDaoCategory;
import com.solvd.sql.model.Category;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements IDaoCategory {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Category category) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO category (category_name) VALUES (?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, category.getCategoryName());
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
    public void update(Category category) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE category SET category_name = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, category.getCategoryName());
            ps.setInt(2, category.getId());
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
        String query = "DELETE FROM category WHERE id = ?";
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
    public List<Category> getAll() throws SQLException {
        Connection con = connectionPool.getConnection();
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM category";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Category category = new Category();
                    category.setId(rs.getInt("id"));
                    category.setCategoryName(rs.getString("category_name"));
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(con);
        }
        return categories;
    }

    @Override
    public Category get(int id) throws SQLException {
        Connection con = connectionPool.getConnection();
        Category category = new Category();
        String query = "SELECT * FROM category WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    category.setId(rs.getInt("id"));
                    category.setCategoryName(rs.getString("category_name"));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        }
        return category;
    }

    @Override
    public Category get(String categoryName) throws SQLException {
        Connection con = connectionPool.getConnection();
        Category category = new Category();
        String query = "SELECT * FROM category WHERE category_name = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, categoryName);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    category.setId(rs.getInt("id"));
                    category.setCategoryName(rs.getString("category_name"));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        }
        return category;
    }
}

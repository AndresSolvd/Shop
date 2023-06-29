package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.ICategoryDao;
import com.solvd.sql.model.Category;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements ICategoryDao {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Category category) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO category (category_name) VALUES (?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, category.getCategoryName());
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
    public void update(Category category) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE category SET category_name = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, category.getCategoryName());
            ps.setInt(2, category.getId());
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
        String query = "DELETE FROM category WHERE id = ?";
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
    public List<Category> getAll() {
        Connection con = connectionPool.getConnection();
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM category";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    categories.add(new Category.Builder()
                            .withId(rs.getInt("id")).
                            withCategoryName(rs.getString("category_name"))
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
        return categories;
    }

    @Override
    public Category getById(int id) {
        Connection con = connectionPool.getConnection();
        Category category;
        String query = "SELECT * FROM category WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                return new Category.Builder()
                        .withId(rs.getInt("id"))
                        .withCategoryName(rs.getString("category_name"))
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

    @Override
    public Category getCategoryByName(String categoryName) {
        Connection con = connectionPool.getConnection();
        String query = "SELECT * FROM category WHERE category_name = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, categoryName);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                return new Category.Builder()
                        .withId(rs.getInt("id"))
                        .withCategoryName(rs.getString("category_name"))
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

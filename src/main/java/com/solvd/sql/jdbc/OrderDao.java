package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.Order;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IBaseDAO<Order> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Order order) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO order (order_date, total, customer_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDate(1, order.getOrderDate());
            ps.setDouble(2, order.getTotal());
            ps.setInt(3, order.getCustomer().getId());
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
    public void update(Order order) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE order SET order_date = ?, total = ?, customer_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDate(1, order.getOrderDate());
            ps.setDouble(2, order.getTotal());
            ps.setInt(3, order.getCustomer().getId());
            ps.setInt(4, order.getId());
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
        String query = "DELETE FROM orders WHERE id = ?";
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
    public List<Order> getAll() {
        Connection con = connectionPool.getConnection();
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    orders.add(new Order.Builder()
                            .withId(rs.getInt("id"))
                            .withOrderDate(rs.getDate("order_date"))
                            .withTotal(rs.getDouble("total"))
                            .withCustomer(new CustomerDao().getById(rs.getInt("customer_id")))
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
        return orders;
    }

    @Override
    public Order getById(int id) {
        Connection con = connectionPool.getConnection();
        String query = "SELECT * FROM order WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                return new Order.Builder()
                        .withId(rs.getInt("id"))
                        .withOrderDate(rs.getDate("order_date"))
                        .withTotal(rs.getDouble("total"))
                        .withCustomer(new CustomerDao().getById(rs.getInt("customer_id")))
                        .build();
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}

package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.Orders;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao implements IBaseDAO<Orders> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Orders orders) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO orders (order_date, total, customer_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDate(1, orders.getOrderDate());
            ps.setDouble(2, orders.getTotal());
            ps.setInt(3, orders.getCustomer().getId());
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
    public void update(Orders orders) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE orders SET order_date = ?, total = ?, customer_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDate(1, orders.getOrderDate());
            ps.setDouble(2, orders.getTotal());
            ps.setInt(3, orders.getCustomer().getId());
            ps.setInt(4, orders.getId());
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
    public List<Orders> getAll() {
        Connection con = connectionPool.getConnection();
        List<Orders> orderss = new ArrayList<>();
        String query = "SELECT * FROM orders";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Orders orders = new Orders();
                    orders.setId(rs.getInt("id"));
                    orders.setOrderDate(rs.getDate("order_date"));
                    orders.setTotal(rs.getDouble("total"));
                    orders.setCustomer(new CustomerDao().getById(rs.getInt("customer_id")));
                    orderss.add(orders);
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
        return orderss;
    }

    @Override
    public Orders getById(int id) {
        Connection con = connectionPool.getConnection();
        Orders orders = new Orders();
        String query = "SELECT * FROM orders WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    orders.setId(rs.getInt("id"));
                    orders.setOrderDate(rs.getDate("order_date"));
                    orders.setTotal(rs.getDouble("total"));
                    orders.setCustomer(new CustomerDao().getById(rs.getInt("customer_id")));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return orders;
    }
}

package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IDaoOrders;
import com.solvd.sql.model.Orders;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao implements IDaoOrders {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Orders orders) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO orders (order_date, total, customer_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDate(1, orders.getOrder_date());
            ps.setDouble(2, orders.getTotal());
            ps.setInt(3, orders.getCustomerId());
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
    public void update(Orders orders) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE orders SET order_date = ?, total = ?, customer_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDate(1, orders.getOrder_date());
            ps.setDouble(2, orders.getTotal());
            ps.setInt(3, orders.getCustomerId());
            ps.setInt(4, orders.getId());
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
        String query = "DELETE FROM orders WHERE id = ?";
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
    public List<Orders> getAll() throws SQLException {
        Connection con = connectionPool.getConnection();
        List<Orders> orderss = new ArrayList<>();
        String query = "SELECT * FROM orders";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Orders orders = new Orders();
                    orders.setId(rs.getInt("id"));
                    orders.setOrder_date(rs.getDate("order_date"));
                    orders.setTotal(rs.getDouble("total"));
                    orders.setCustomerId(rs.getInt("customer_id"));
                    orderss.add(orders);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(con);
        }
        return orderss;
    }

    @Override
    public Orders get(int id) throws SQLException {
        Connection con = connectionPool.getConnection();
        Orders orders = new Orders();
        String query = "SELECT * FROM orders WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    orders.setId(rs.getInt("id"));
                    orders.setOrder_date(rs.getDate("order_date"));
                    orders.setTotal(rs.getDouble("total"));
                    orders.setCustomerId(rs.getInt("customer_id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        }
        return orders;
    }
}

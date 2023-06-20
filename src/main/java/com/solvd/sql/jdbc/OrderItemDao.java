package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.OrderItem;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDao implements IBaseDAO<OrderItem> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(OrderItem orderItem) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO order_item (quantity, product_id, order_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, orderItem.getQuantity());
            ps.setInt(2, orderItem.getProduct().getId());
            ps.setInt(3, orderItem.getOrder().getId());
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
    public void update(OrderItem orderItem) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE order_item SET quantity = ?, product_id = ? WHERE order_id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, orderItem.getQuantity());
            ps.setInt(2, orderItem.getProduct().getId());
            ps.setInt(3, orderItem.getOrder().getId());
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
        String query = "DELETE FROM order_item WHERE order_id = ?";
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
    public List<OrderItem> getAll() {
        Connection con = connectionPool.getConnection();
        List<OrderItem> orderItems = new ArrayList<>();
        String query = "SELECT * FROM order_item";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setQuantity(rs.getInt("quantity"));
                    orderItem.setProduct(new ProductDao().getById(rs.getInt("product_id")));
                    orderItem.setOrder(new OrderDao().getById(rs.getInt("order_id")));
                    orderItems.add(orderItem);
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
        return orderItems;
    }

    @Override
    public OrderItem getById(int id) {
        Connection con = connectionPool.getConnection();
        OrderItem orderItem = new OrderItem();
        String query = "SELECT * FROM order_item WHERE order_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    orderItem.setQuantity(rs.getInt("quantity"));
                    orderItem.setProduct(new ProductDao().getById(rs.getInt("product_id")));
                    orderItem.setOrder(new OrderDao().getById(rs.getInt("order_id")));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return orderItem;
    }
}
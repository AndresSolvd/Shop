package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.Shop;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDao implements IBaseDAO<Shop> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Shop shop) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO shop (shop_name, address, phone, owner_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, shop.getShopName());
            ps.setString(2, shop.getAddress());
            ps.setString(3, shop.getPhone());
            ps.setInt(4, shop.getOwnerId());
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
    public void update(Shop shop) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE shop SET shop_name = ?, address = ?, phone = ?, owner_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, shop.getShopName());
            ps.setString(2, shop.getAddress());
            ps.setString(3, shop.getPhone());
            ps.setInt(4, shop.getOwnerId());
            ps.setInt(5, shop.getId());
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
        String query = "DELETE FROM shop WHERE id = ?";
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
    public List<Shop> getAll() throws SQLException {
        Connection con = connectionPool.getConnection();
        List<Shop> shops = new ArrayList<>();
        String query = "SELECT * FROM shop";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Shop shop = new Shop();
                    shop.setId(rs.getInt("id"));
                    shop.setShopName(rs.getString("shop_name"));
                    shop.setAddress(rs.getString("address"));
                    shop.setPhone(rs.getString("phone"));
                    shop.setOwnerId(rs.getInt("owner_id"));
                    shops.add(shop);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(con);
        }
        return shops;
    }

    @Override
    public Shop get(int id) throws SQLException {
        Connection con = connectionPool.getConnection();
        Shop shop = new Shop();
        String query = "SELECT * FROM shop WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    shop.setShopName(rs.getString("shop_name"));
                    shop.setAddress(rs.getString("address"));
                    shop.setPhone(rs.getString("phone"));
                    shop.setOwnerId(rs.getInt("owner_id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        }
        return shop;
    }
}

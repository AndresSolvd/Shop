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
    public void insert(Shop shop) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO shop (shop_name, address, phone, owner_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, shop.getShopName());
            ps.setString(2, shop.getAddress());
            ps.setString(3, shop.getPhone());
            ps.setInt(4, shop.getOwner().getId());
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
    public void update(Shop shop) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE shop SET shop_name = ?, address = ?, phone = ?, owner_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, shop.getShopName());
            ps.setString(2, shop.getAddress());
            ps.setString(3, shop.getPhone());
            ps.setInt(4, shop.getOwner().getId());
            ps.setInt(5, shop.getId());
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
        String query = "DELETE FROM shop WHERE id = ?";
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
    public List<Shop> getAll() {
        Connection con = connectionPool.getConnection();
        List<Shop> shops = new ArrayList<>();
        String query = "SELECT * FROM shop";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    shops.add(new Shop.Builder()
                            .withId(rs.getInt("id"))
                            .withShopName(rs.getString("shop_name"))
                            .withAddress(rs.getString("address"))
                            .withPhone(rs.getString("phone"))
                            .withOwner(new OwnerDao().getById(rs.getInt("owner_id")))
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
        return shops;
    }

    @Override
    public Shop getById(int id) {
        Connection con = connectionPool.getConnection();
        String query = "SELECT * FROM shop WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                return new Shop.Builder()
                        .withId(rs.getInt("id"))
                        .withShopName(rs.getString("shop_name"))
                        .withAddress(rs.getString("address"))
                        .withPhone(rs.getString("phone"))
                        .withOwner(new OwnerDao().getById(rs.getInt("owner_id")))
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

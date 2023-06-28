package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.Staff;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDao implements IBaseDAO<Staff> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Staff staff) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO staff (position, person_id, shop_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, staff.getPosition());
            ps.setInt(2, staff.getPerson().getId());
            ps.setInt(3, staff.getShop().getId());
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
    public void update(Staff staff) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE staff SET position = ?, person_id = ?, shop_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, staff.getPosition());
            ps.setInt(2, staff.getPerson().getId());
            ps.setInt(3, staff.getShop().getId());
            ps.setInt(4, staff.getId());
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
        String query = "DELETE FROM staff WHERE id = ?";
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
    public List<Staff> getAll() {
        Connection con = connectionPool.getConnection();
        List<Staff> staffs = new ArrayList<>();
        String query = "SELECT * FROM staff";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    staffs.add(new Staff.Builder()
                            .withId(rs.getInt("id"))
                            .withPosition(rs.getString("position"))
                            .withPerson(new PersonDao().getById(rs.getInt("person_id")))
                            .withShop(new ShopDao().getById(rs.getInt("shop_id")))
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
        return staffs;
    }

    @Override
    public Staff getById(int id) {
        Connection con = connectionPool.getConnection();
        String query = "SELECT * FROM staff WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                return new Staff.Builder()
                        .withId(rs.getInt("id"))
                        .withPosition(rs.getString("position"))
                        .withPerson(new PersonDao().getById(rs.getInt("person_id")))
                        .withShop(new ShopDao().getById(rs.getInt("shop_id")))
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

package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IDaoStaff;
import com.solvd.sql.model.Staff;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoStaff implements IDaoStaff {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Staff staff) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO staff (position, person_id, shop_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, staff.getPosition());
            ps.setInt(2, staff.getPersonId());
            ps.setInt(3, staff.getShopId());
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
    public void update(Staff staff) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE staff SET position = ?, person_id = ?, shop_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, staff.getPosition());
            ps.setInt(2, staff.getPersonId());
            ps.setInt(3, staff.getShopId());
            ps.setInt(5, staff.getId());
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
        String query = "DELETE FROM staff WHERE id = ?";
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
    public List<Staff> getAll() throws SQLException {
        Connection con = connectionPool.getConnection();
        List<Staff> staffs = new ArrayList<>();
        String query = "SELECT * FROM staff";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Staff staff = new Staff();
                    staff.setId(rs.getInt("id"));
                    staff.setPosition(rs.getString("position"));
                    staff.setPersonId(rs.getInt("person_id"));
                    staff.setShopId(rs.getInt("shop_id"));
                    staffs.add(staff);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(con);
        }
        return staffs;
    }

    @Override
    public Staff get(int id) throws SQLException {
        Connection con = connectionPool.getConnection();
        Staff staff = new Staff();
        String query = "SELECT * FROM staff WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    staff.setId(rs.getInt("id"));
                    staff.setPosition(rs.getString("position"));
                    staff.setPersonId(rs.getInt("person_id"));
                    staff.setShopId(rs.getInt("shop_id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        }
        return staff;
    }
}

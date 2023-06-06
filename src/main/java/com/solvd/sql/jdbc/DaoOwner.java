package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IDaoOwner;
import com.solvd.sql.model.Owner;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoOwner implements IDaoOwner {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Owner owner) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO owner (person_id) VALUES (?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, owner.getPersonId());
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
    public void update(Owner owner) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE owner SET person_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, owner.getPersonId());
            ps.setInt(2, owner.getId());
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
        String query = "DELETE FROM owner WHERE id = ?";
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
    public List<Owner> getAll() throws SQLException {
        Connection con = connectionPool.getConnection();
        List<Owner> owners = new ArrayList<>();
        String query = "SELECT * FROM owner";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Owner owner = new Owner();
                    owner.setId(rs.getInt("id"));
                    owner.setPersonId(rs.getInt("person_id"));
                    owners.add(owner);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(con);
        }
        return owners;
    }

    @Override
    public Owner get(int id) throws SQLException {
        Connection con = connectionPool.getConnection();
        Owner owner = new Owner();
        String query = "SELECT * FROM owner WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    owner.setId(rs.getInt("id"));
                    owner.setPersonId(rs.getInt("person_id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        }
        return owner;
    }
}

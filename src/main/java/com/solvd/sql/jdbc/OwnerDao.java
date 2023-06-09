package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.Owner;
import com.solvd.util.ConnectionPool;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "OwnerDao")
public class OwnerDao implements IBaseDAO<Owner>{

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Owner owner) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO owner (person_id) VALUES (?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, owner.getPersonId());
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
    public void update(Owner owner) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE owner SET person_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, owner.getPersonId());
            ps.setInt(2, owner.getId());
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
        String query = "DELETE FROM owner WHERE id = ?";
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
    public List<Owner> getAll() {
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
            try {
                connectionPool.releaseConnection(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return owners;
    }

    @Override
    public Owner getById(int id) {
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
                try {
                    connectionPool.releaseConnection(con);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return owner;
    }
}

package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.Customer;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements IBaseDAO<Customer> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Customer customer) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO customer (tax_number, person_id) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, customer.getTaxNumber());
            ps.setInt(2, customer.getPerson().getId());
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
    public void update(Customer customer) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE customer SET tax_number = ?, person_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, customer.getTaxNumber());
            ps.setInt(2, customer.getPerson().getId());
            ps.setInt(3, customer.getId());
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
        String query = "DELETE FROM customer WHERE id = ?";
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
    public List<Customer> getAll() {
        Connection con = connectionPool.getConnection();
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    customers.add(new Customer.Builder()
                            .withId(rs.getInt("id"))
                            .withTaxNumber(rs.getString("tax_number"))
                            .withPerson(new PersonDao().getById(rs.getInt("person_id")))
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
        return customers;
    }

    @Override
    public Customer getById(int id) {
        Connection con = connectionPool.getConnection();
        String query = "SELECT * FROM customer WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                return new Customer.Builder()
                        .withId(rs.getInt("id"))
                        .withTaxNumber(rs.getString("tax_number"))
                        .withPerson(new PersonDao().getById(rs.getInt("person_id")))
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
package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IDaoCustomer;
import com.solvd.sql.model.Category;
import com.solvd.sql.model.Customer;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCustomer implements IDaoCustomer {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public void insert(Customer customer) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO customer (tax_number, person_id) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, customer.getTaxNumber());
            ps.setInt(1, customer.getPersonId());
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
    public void update(Customer customer) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE customer SET tax_number = ?, person_id = ?, WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, customer.getTaxNumber());
            ps.setInt(2, customer.getPersonId());
            ps.setInt(3, customer.getId());
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
        String query = "DELETE FROM customer WHERE id = ?";
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
    public List<Customer> getAll() throws SQLException {
        Connection con = connectionPool.getConnection();
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while ( rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setTaxNumber(rs.getString("tax_number"));
                    customer.setPersonId(rs.getInt("person_id"));
                    customers.add(customer);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(con);
        }
        return customers;
    }

    @Override
    public Customer get(int id) throws SQLException {
        Connection con = connectionPool.getConnection();
        Customer customer = new Customer();
        String query = "SELECT * FROM customer WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    customer.setId(rs.getInt("id"));
                    customer.setTaxNumber(rs.getString("tax_number"));
                    customer.setPersonId(rs.getInt("person_id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        }
        return customer;
    }
}
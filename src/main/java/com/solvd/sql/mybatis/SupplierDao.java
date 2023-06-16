package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.Supplier;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDao implements IBaseDAO<Supplier> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Supplier supplier) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO supplier (supplier_name, tax_number, phone) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getTaxNumber());
            ps.setString(3, supplier.getPhone());
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
    public void update(Supplier supplier) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE supplier SET supplier_name = ?, tax_number = ?, phone = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getTaxNumber());
            ps.setString(3, supplier.getPhone());
            ps.setInt(4, supplier.getId());
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
        String query = "DELETE FROM supplier WHERE id = ?";
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
    public List<Supplier> getAll() {
        Connection con = connectionPool.getConnection();
        List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT * FROM supplier";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Supplier supplier = new Supplier();
                    supplier.setId(rs.getInt("id"));
                    supplier.setSupplierName(rs.getString("supplier_name"));
                    supplier.setTaxNumber(rs.getString("tax_number"));
                    supplier.setPhone(rs.getString("phone"));
                    suppliers.add(supplier);
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
        return suppliers;
    }

    @Override
    public Supplier getById(int id) {
        Connection con = connectionPool.getConnection();
        Supplier supplier = new Supplier();
        String query = "SELECT * FROM supplier WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    supplier.setId(rs.getInt("id"));
                    supplier.setSupplierName(rs.getString("supplier_name"));
                    supplier.setTaxNumber(rs.getString("tax_number"));
                    supplier.setPhone(rs.getString("phone"));
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
        return supplier;
    }
}

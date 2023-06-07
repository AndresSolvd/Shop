package com.solvd.sql.services;

import com.solvd.sql.interfaces.ISupplierDao;
import com.solvd.sql.jdbc.SupplierDao;
import com.solvd.sql.model.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierService implements ISupplierDao {

    SupplierDao supplierDao = new SupplierDao();

    @Override
    public void insert(Supplier supplier) throws SQLException {
        supplierDao.insert(supplier);
    }

    @Override
    public void update(Supplier supplier) throws SQLException {
        supplierDao.update(supplier);
    }

    @Override
    public void delete(int id) throws SQLException {
        supplierDao.delete(id);
    }

    @Override
    public List<Supplier> getAll() throws SQLException {
        return supplierDao.getAll();
    }

    @Override
    public Supplier getById(int id) throws SQLException {
        return supplierDao.getById(id);
    }
}

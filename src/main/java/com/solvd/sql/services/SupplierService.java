package com.solvd.sql.services;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.jdbc.SupplierDao;
import com.solvd.sql.model.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierService implements IBaseDAO<Supplier> {

    SupplierDao supplierDao = new SupplierDao();

    @Override
    public void insert(Supplier supplier) {
        supplierDao.insert(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierDao.update(supplier);
    }

    @Override
    public void delete(int id) {
        supplierDao.delete(id);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierDao.getAll();
    }

    @Override
    public Supplier getById(int id) {
        return supplierDao.getById(id);
    }
}

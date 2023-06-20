package com.solvd.sql.services;

import com.solvd.sql.interfaces.ISupplierDao;
import com.solvd.sql.model.Supplier;
import com.solvd.sql.mybatis.SupplierDao;

import java.util.List;

public class SupplierService implements ISupplierDao {

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

    @Override
    public Supplier getSupplierByName(String name) {
        return supplierDao.getSupplierByName(name);
    }
}

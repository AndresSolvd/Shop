package com.solvd.sql.services;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.jdbc.OwnerDao;
import com.solvd.sql.model.Owner;

import java.util.List;

public class OwnerService implements IBaseDAO<Owner> {

    OwnerDao ownerDao = new OwnerDao();

    @Override
    public void insert(Owner owner) {
        ownerDao.insert(owner);
    }

    @Override
    public void update(Owner owner) {
        ownerDao.update(owner);
    }

    @Override
    public void delete(int id) {
        ownerDao.delete(id);
    }

    @Override
    public List<Owner> getAll() {
        return ownerDao.getAll();
    }

    @Override
    public Owner getById(int id) {
        return ownerDao.getById(id);
    }
}

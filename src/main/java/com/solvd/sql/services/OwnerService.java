package com.solvd.sql.services;

import com.solvd.sql.interfaces.IOwnerDao;
import com.solvd.sql.jdbc.OwnerDao;
import com.solvd.sql.model.Owner;

import java.sql.SQLException;
import java.util.List;

public class OwnerService implements IOwnerDao {

    OwnerDao ownerDao = new OwnerDao();

    @Override
    public void insert(Owner owner) throws SQLException {
        ownerDao.insert(owner);
    }

    @Override
    public void update(Owner owner) throws SQLException {
        ownerDao.update(owner);
    }

    @Override
    public void delete(int id) throws SQLException {
        ownerDao.delete(id);
    }

    @Override
    public List<Owner> getAll() throws SQLException {
        return ownerDao.getAll();
    }

    @Override
    public Owner getById(int id) throws SQLException {
        return ownerDao.getById(id);
    }
}

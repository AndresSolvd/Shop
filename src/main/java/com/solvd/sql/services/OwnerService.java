package com.solvd.sql.services;

import com.solvd.sql.interfaces.IOwnerDao;
import com.solvd.sql.model.Owner;
import com.solvd.sql.mybatis.OwnerDao;
import com.solvd.util.Creator;

import java.util.List;

public class OwnerService implements IOwnerDao {

    OwnerDao ownerDao = new OwnerDao();

    @Override
    public void insert(Owner owner) {

        OwnerService ownerService = new OwnerService();

        // Check if owner exist
        List<Owner> owners;
        owners = ownerService.getAll();
        if (!owners.contains(owner)) {
            ownerDao.insert(owner);
        } else {
            Creator.createOwner();
        }
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
        if (ownerDao.getById(id) == null) {
            return Creator.optionsToCreateAnOwner();
        }
        return ownerDao.getById(id);
    }

    @Override
    public Owner getOwnerByName(String name) {
        return ownerDao.getOwnerByName(name);
    }
}

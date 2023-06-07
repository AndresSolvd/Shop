package com.solvd.sql.services;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.jdbc.StaffDao;
import com.solvd.sql.model.Staff;

import java.util.List;

public class StaffService implements IBaseDAO<Staff> {

    StaffDao staffDao = new StaffDao();

    @Override
    public void insert(Staff staff) {
        staffDao.insert(staff);
    }

    @Override
    public void update(Staff staff) {
        staffDao.update(staff);
    }

    @Override
    public void delete(int id) {
        staffDao.delete(id);
    }

    @Override
    public List<Staff> getAll() {
        return staffDao.getAll();
    }

    @Override
    public Staff getById(int id) {
        return staffDao.getById(id);
    }
}

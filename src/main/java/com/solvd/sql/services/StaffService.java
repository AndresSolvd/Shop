package com.solvd.sql.services;

import com.solvd.sql.interfaces.IStaffDao;
import com.solvd.sql.jdbc.StaffDao;
import com.solvd.sql.model.Staff;

import java.sql.SQLException;
import java.util.List;

public class StaffService implements IStaffDao {

    StaffDao staffDao = new StaffDao();

    @Override
    public void insert(Staff staff) throws SQLException {
        staffDao.insert(staff);
    }

    @Override
    public void update(Staff staff) throws SQLException {
        staffDao.update(staff);
    }

    @Override
    public void delete(int id) throws SQLException {
        staffDao.delete(id);
    }

    @Override
    public List<Staff> getAll() throws SQLException {
        return staffDao.getAll();
    }

    @Override
    public Staff getById(int id) throws SQLException {
        return staffDao.getById(id);
    }
}

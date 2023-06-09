package com.solvd.sql.services;

import com.solvd.sql.interfaces.IStaffDao;
import com.solvd.sql.model.Staff;
import com.solvd.sql.mybatis.StaffDao;

import java.util.List;

public class StaffService implements IStaffDao {

    StaffDao staffDao = new StaffDao();

    @Override
    public void insert(Staff staff) {
        PersonService personService = new PersonService();
        if (personService.getById(staff.getPerson().getId()) == null) {
            personService.insert(staff.getPerson());
        }
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

    @Override
    public Staff getStaffByName(String name) {
        return staffDao.getStaffByName(name);
    }
}

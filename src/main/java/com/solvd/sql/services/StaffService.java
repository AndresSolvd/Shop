package com.solvd.sql.services;

import com.solvd.sql.interfaces.IStaffDao;
import com.solvd.sql.model.Person;
import com.solvd.sql.model.Staff;
import com.solvd.sql.mybatis.StaffDao;

import java.util.List;

public class StaffService implements IStaffDao {

    StaffDao staffDao = new StaffDao();

    @Override
    public void insert(Staff staff) {
        PersonService personService = new PersonService();
        Person person = staff.getPerson();
        List<Person> persons = personService.getAll();
        List<Staff> staffs = new StaffService().getAll();
        boolean exists = false;

        // Search in database for the same person
        for (Person p : persons) {
            if (p.getPersonName().equals(person.getPersonName()) &&
                    p.getLastName().equals(person.getLastName()) &&
                    p.getPhone().equals(person.getPhone()) &&
                    p.getAddress().equals(person.getAddress())) {
                // if person exists add that person to the staff object
                staff.setPerson(p);
                exists = true;
            }
        }

        // Check if staff with that person already exists
        if (exists) {
            for (Staff s : staffs) {
                if (s.getPerson().getPersonName().equals(staff.getPerson().getPersonName()) &&
                        s.getPerson().getLastName().equals(staff.getPerson().getLastName()) &&
                        s.getPerson().getPhone().equals(staff.getPerson().getPhone()) &&
                        s.getPerson().getAddress().equals(staff.getPerson().getAddress())) {
                    System.out.println(s.getPerson().getPersonName() + " " + s.getPerson().getLastName()
                            + " already exist as staff. (staffId: " + s.getId() +
                            " personId: " + s.getPerson().getId() + ")");
                    return;
                }
            }
        }

        if (!exists) {
            // if person does not exist create a new person in the database
            personService.insert(staff.getPerson());
        }
        // Insert staff in the Database
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

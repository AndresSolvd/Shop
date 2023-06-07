package com.solvd.sql.services;

import com.solvd.sql.interfaces.IPersonDao;
import com.solvd.sql.jdbc.PersonDao;
import com.solvd.sql.model.Person;

import java.sql.SQLException;
import java.util.List;

public class PersonService implements IPersonDao {

    PersonDao personDao = new PersonDao();

    @Override
    public void insert(Person person) throws SQLException {
        personDao.insert(person);
    }

    @Override
    public void update(Person person) throws SQLException {
        personDao.update(person);
    }

    @Override
    public void delete(int id) throws SQLException {
        personDao.delete(id);
    }

    @Override
    public List<Person> getAll() throws SQLException {
        return personDao.getAll();
    }

    @Override
    public Person getById(int id) throws SQLException {
        return personDao.getById(id);
    }
}
package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IPersonDAO;
import com.solvd.sql.model.Person;
import com.solvd.util.ConnectionPool;

import java.util.List;

public class PersonDAO implements IPersonDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public void saveEntity(Person model) {

    }

    @Override
    public Person getByID(int id) {
        return null;
    }

    @Override
    public void updateEntity(Person person) {

    }

    @Override
    public void removeEntityById(Person person) {

    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public List<Person> getPersonFirstName(String firstName) {
        return null;
    }
}

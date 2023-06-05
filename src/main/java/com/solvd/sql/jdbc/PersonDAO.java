package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IPersonDAO;
import com.solvd.sql.model.Person;
import com.solvd.util.ConnectionPool;

import java.sql.SQLException;
import java.util.List;

public class PersonDAO implements IPersonDAO {


    @Override
    public void insert(Person person) throws SQLException {

    }

    @Override
    public Person get(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Person person) throws SQLException {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public List<Person> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Person> getPersonFirstName(String firstName) {
        return null;
    }
}

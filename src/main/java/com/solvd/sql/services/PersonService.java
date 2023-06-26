package com.solvd.sql.services;

import com.solvd.sql.interfaces.IPersonDao;
import com.solvd.sql.model.Person;
import com.solvd.sql.mybatis.PersonDao;

import java.util.List;

public class PersonService implements IPersonDao {

    PersonDao personDao = new PersonDao();

    @Override
    public void insert(Person person) {
        personDao.insert(person);
    }

    @Override
    public void update(Person person) {
        personDao.update(person);
    }

    @Override
    public void delete(int id) {
        personDao.delete(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public Person getById(int id) {
        return personDao.getById(id);
    }

    @Override
    public Person getPersonByName(String name) {
        return personDao.getPersonByName(name);
    }
}
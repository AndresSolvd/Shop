package com.solvd.sql.services;

import com.solvd.sql.interfaces.IOwnerDao;
import com.solvd.sql.model.Owner;
import com.solvd.sql.model.Person;
import com.solvd.sql.mybatis.OwnerDao;

import java.util.List;

public class OwnerService implements IOwnerDao {

    OwnerDao ownerDao = new OwnerDao();

    @Override
    public void insert(Owner owner) {
        PersonService personService = new PersonService();
        Person person = owner.getPerson();
        List<Person> persons = personService.getAll();
        List<Owner> owners = new OwnerService().getAll();
        boolean exists = false;

        // Search in database for the same person
        for (Person p : persons) {
            if (p.getPersonName().equals(person.getPersonName()) &&
                    p.getLastName().equals(person.getLastName()) &&
                    p.getPhone().equals(person.getPhone()) &&
                    p.getAddress().equals(person.getAddress())) {
                // if person exists add that person to the owner object
                owner.setPerson(p);
                exists = true;
            }
        }

        // Check if owner with that person already exists
        if (exists) {
            for (Owner o : owners) {
                if (o.getPerson().getPersonName().equals(owner.getPerson().getPersonName()) &&
                        o.getPerson().getLastName().equals(owner.getPerson().getLastName()) &&
                        o.getPerson().getPhone().equals(owner.getPerson().getPhone()) &&
                        o.getPerson().getAddress().equals(owner.getPerson().getAddress())) {
                    System.out.println(o.getPerson().getPersonName() + " " + o.getPerson().getLastName()
                            + " already exist as owner.(ownerId: " + o.getId() +
                            " personId: " + o.getPerson().getId() + ")");
                    return;
                }
            }
        }

        if (!exists) {
            // if person does not exist create a new person in the database
            personService.insert(owner.getPerson());
        }
        // Insert owner in the Database
        ownerDao.insert(owner);
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
        return ownerDao.getById(id);
    }

    @Override
    public Owner getOwnerByName(String name) {
        return ownerDao.getOwnerByName(name);
    }
}

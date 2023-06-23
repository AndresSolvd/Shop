package com.solvd.sql.services;

import com.solvd.sql.interfaces.ICustomerDao;
import com.solvd.sql.model.Customer;
import com.solvd.sql.model.Person;
import com.solvd.sql.mybatis.CustomerDao;

import java.util.List;

public class CustomerService implements ICustomerDao {

    CustomerDao customerDao = new CustomerDao();

    @Override
    public void insert(Customer customer) {
        PersonService personService = new PersonService();
        Person person = customer.getPerson();
        List<Person> persons = personService.getAll();
        List<Customer> customers = new CustomerService().getAll();
        boolean exists = false;

        // Search in database for the same person
        for (Person p : persons) {
            if (p.getPersonName().equals(person.getPersonName()) &&
                    p.getLastName().equals(person.getLastName()) &&
                    p.getPhone().equals(person.getPhone()) &&
                    p.getAddress().equals(person.getAddress())) {
                // if person exists add that person to the customer object
                customer.setPerson(p);
                exists = true;
            }
        }

        // Check if customer with that person already exists
        if (exists) {
            for (Customer c : customers) {
                if (c.getPerson().getPersonName().equals(customer.getPerson().getPersonName()) &&
                        c.getPerson().getLastName().equals(customer.getPerson().getLastName()) &&
                        c.getPerson().getPhone().equals(customer.getPerson().getPhone()) &&
                        c.getPerson().getAddress().equals(customer.getPerson().getAddress())) {
                    System.out.println(c.getPerson().getPersonName() + " " + c.getPerson().getLastName()
                            + " already exist as customer.(customerId: " + c.getId() +
                            " personId: " + c.getPerson().getId() + ")");
                    return;
                }
            }
        }

        if (!exists) {
            // if person does not exist create a new person in the database
            personService.insert(customer.getPerson());
        }
        // Insert customer in the Database
        customerDao.insert(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void delete(int id) {
        customerDao.delete(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Override
    public Customer getById(int id) {
        return customerDao.getById(id);
    }

    @Override
    public Customer getCustomerByName(String name) {
        return customerDao.getCustomerByName(name);
    }
}

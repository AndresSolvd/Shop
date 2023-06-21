package com.solvd.sql.services;

import com.solvd.sql.interfaces.IPersonDao;
import com.solvd.sql.model.Person;
import com.solvd.sql.mybatis.PersonDao;

import java.util.List;
import java.util.Scanner;

public class PersonService implements IPersonDao {

    PersonDao personDao = new PersonDao();

    @Override
    public void insert(Person person) {

        PersonService personService = new PersonService();

        // Check if person exist
        List<Person> persons;
        persons = personService.getAll();
        if (!persons.contains(person)) {
            personDao.insert(person);
        } else {
            createPerson();
        }
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
        if (personDao.getById(id) == null) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("The provided id does not match any person on the Database\n" +
                        "enter '1' to create a new person\n" +
                        "enter '2' to get a list of all persons in the Database\n" +
                        "enter '3' to cancel this transaction");
                String answer = scanner.nextLine();
                switch (answer) {
                    case "1":
                        return new PersonService().createPerson();
                    case "2":
                        System.out.println("List of all persons in Database\n" + new PersonService().getAll()
                                + "\n *** end *** \nInput new id: ");
                        return getById(scanner.nextInt());
                    case "3":
                        return null; // Transaction canceled
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        }
        return personDao.getById(id);
    }

    @Override
    public Person getPersonByName(String name) {
        return personDao.getPersonByName(name);
    }

    public Person createPerson() {

        Person person = new Person();
        PersonService personService = new PersonService();
        Scanner scanner = new Scanner(System.in);

        // input data
        System.out.println("Enter Person name: ");
        person.setPersonName(scanner.nextLine());
        System.out.println("Enter last name");
        person.setLastName(scanner.nextLine());
        System.out.println("Enter Phone number");
        person.setPhone(scanner.nextLine());
        System.out.println("Enter Address");
        person.setAddress(scanner.nextLine());
        scanner.close();

        // Insert into Database
        personService.insert(person);

        // Recover person to get the id
        List<Person> persons = personService.getAll();
        for (Person p : persons) {
            if (p.getPersonName().equals(person.getPersonName()) &&
                    p.getLastName().equals(person.getLastName()) &&
                    p.getPhone().equals(person.getPhone()) &&
                    p.getAddress().equals(person.getAddress())) {
                person = p;
            }
        }
        System.out.println("New Person created: \n" + person + "\n   *****   \n");
        return person;
    }
}
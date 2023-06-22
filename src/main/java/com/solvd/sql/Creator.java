package com.solvd.sql;

import com.solvd.sql.model.Owner;
import com.solvd.sql.model.Person;
import com.solvd.sql.services.OwnerService;
import com.solvd.sql.services.PersonService;

import java.util.List;
import java.util.Scanner;

public class Creator {

    public static Person optionsToCreateAPerson() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("The provided id does not match any person on the Database\n" +
                    "enter '1' to create a new person\n" +
                    "enter '2' to get a list of all persons in the Database\n" +
                    "enter '3' to cancel this transaction");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    return Creator.createPerson();
                case "2":
                    System.out.println("List of all persons in Database\n" + new PersonService().getAll()
                            + "\n *** end *** \nInput new id: ");
                    return new PersonService().getById(scanner.nextInt());
                case "3":
                    return null; // Transaction canceled
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public static Owner optionsToCreateAnOwner() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("The provided id does not match any owner on the Database\n" +
                    "enter '1' to create a new owner\n" +
                    "enter '2' to get a list of all owners in the Database\n" +
                    "enter '3' to cancel this transaction");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    return new Creator().createOwner();
                case "2":
                    System.out.println("List of all owners in Database\n" + new OwnerService().getAll()
                            + "\n *** end *** \nInput new id: ");
                    return new OwnerService().getById(scanner.nextInt());
                case "3":
                    return null; // Transaction canceled
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }

    public static Person createPerson() {

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

    public Owner createOwner() {

        Owner owner = new Owner();
        OwnerService ownerService = new OwnerService();
        PersonService personService = new PersonService();
        Scanner scanner = new Scanner(System.in);

        // input data
        System.out.println("Enter Person id: ");
        owner.setPerson(personService.getById(scanner.nextInt()));
        scanner.close();

        // Insert into Database
        ownerService.insert(owner);

        // Recover person to get the id
        List<Owner> owners = ownerService.getAll();
        for (Owner o : owners) {
            if (o.getPerson().equals(owner.getPerson())) {
                owner = o;
            }
        }
        System.out.println("New Person created: \n" + owner + "\n   *****   \n");
        return owner;
    }
}

package com.solvd.sql.services;

import com.solvd.sql.interfaces.IOwnerDao;
import com.solvd.sql.model.Owner;
import com.solvd.sql.mybatis.OwnerDao;

import java.util.List;
import java.util.Scanner;

public class OwnerService implements IOwnerDao {

    OwnerDao ownerDao = new OwnerDao();

    @Override
    public void insert(Owner owner) {

        OwnerService ownerService = new OwnerService();

        // Check if person exist
        List<Owner> owners;
        owners = ownerService.getAll();
        if (!owners.contains(owner)) {
            ownerDao.insert(owner);
        } else {
            createOwner();
        }


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
        if (ownerDao.getById(id) == null) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("The provided id does not match any owner on the Database\n" +
                        "enter '1' to create a new owner\n" +
                        "enter '2' to get a list of all owners in the Database\n" +
                        "enter '3' to cancel this transaction");
                String answer = scanner.nextLine();
                switch (answer) {
                    case "1":
                        return new OwnerService().createOwner();
                    case "2":
                        System.out.println("List of all owners in Database\n" + new OwnerService().getAll()
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
        return ownerDao.getById(id);
    }

    @Override
    public Owner getOwnerByName(String name) {
        return ownerDao.getOwnerByName(name);
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

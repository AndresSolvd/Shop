package com.solvd;

import com.solvd.sql.model.*;
import com.solvd.sql.mybatis.*;


public class MyBatisMain {
    public static void main(String[] args) {

        // CATEGORY
        System.out.println("\nCategory");
        // test Print all
        System.out.println(new CategoryDao().getAll());
        // Insert
        Category category = new Category();
        category.setCategoryName("plants");
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.insert(category);
        // Print by id
        System.out.println(new CategoryDao().getById(1));
        // Print by name
        System.out.println(new CategoryDao().getByName("plants")); // Empty DB as repeated categories throw error
        // Print all
        System.out.println(new CategoryDao().getAll());
        // Update
        category = new CategoryDao().getById(1);
        category.setCategoryName("Candies");
        categoryDao.update(category);
        System.out.println(new CategoryDao().getById(1));
        // Delete
        new CategoryDao().delete(1);
        System.out.println(new CategoryDao().getById(1));

        // PERSON
        System.out.println("\nPerson");
        //test
        System.out.println(new PersonDao().getAll());
        // Insert
        Person person = new Person();
        person.setPersonName("Alfredo");
        person.setLastName("Martinez");
        person.setPhone("2340984759");
        person.setAddress(("somewhere before the horizon"));
        PersonDao personDao = new PersonDao();
        personDao.insert(person);
        person.setPersonName("Roberto");
        person.setLastName("Fernandez");
        person.setPhone("54329887315");
        person.setAddress(("somewhere after the horizon"));
        personDao.insert(person);
        // Print by id
        System.out.println(new PersonDao().getById(2));
        // Update
        person = new PersonDao().getById(2);
        person.setPersonName("Patricio");
        personDao.update(person);
        System.out.println(new PersonDao().getById(2));
        //Delete
        new PersonDao().delete(2);
        System.out.println(new PersonDao().getAll());

//        // CUSTOMER
//        System.out.println("\nCustomers");
//        //test
//        System.out.println(new CustomerDao().getAll());
//        // Insert
//        Customer customer = new Customer();
//        customer.setTaxNumber("4532168");
//        customer.setPersonId(1);
//        CustomerDao customerDao = new CustomerDao();
//        customerDao.insert(customer);
//        // Print by id
//        System.out.println(new CustomerDao().getById(1));
//        // Update
//        customer.setTaxNumber("55555555");
//        new CustomerDao().update(customer);
//        System.out.println(new CustomerDao().getById(1));
//        //Delete
//        new CustomerDao().delete(1);
//        System.out.println(new CustomerDao().getAll());






    }
}

package com.solvd;

import com.solvd.sql.jdbc.DaoCategory;
import com.solvd.sql.jdbc.DaoCustomer;
import com.solvd.sql.model.Category;
import com.solvd.sql.model.Customer;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        // CATEGORY
        // Create
        DaoCategory daoCategory = new DaoCategory();
        Category category = new Category();
        category.setCategoryName("The test Discount");
        daoCategory.insert(category);
        category.setCategoryName("Another test Discount");
        daoCategory.insert(category);
        // Update
        category.setCategoryName("Update Discount"); // Needs to specify the ID
        category.setId(3);
        daoCategory.update(category);
        // Delete
        daoCategory.delete(2);
        // Read
        System.out.println(daoCategory.get(1));
        System.out.println(daoCategory.get("Update Discount")); // If repeated name select the last.
        System.out.println(daoCategory.get("The Test Discount")); // If repeated name select the last.
        // All
        System.out.println(daoCategory.getAll());

        // CUSTOMER
        // Create
        DaoCustomer daoCustomer = new DaoCustomer();
        Customer customer = new Customer();
        customer.setTaxNumber("00998877");
        customer.setPersonId(1);
        daoCustomer.insert(customer);
        customer.setTaxNumber("77889900");
        customer.setPersonId(2);
        daoCustomer.insert(customer);
/*        // Update
        category.setCategoryName("Update Discount"); // Needs to specify the ID
        category.setId(3);
        daoCategory.update(category);
        // Delete
        daoCategory.delete(2);
        // Read
        System.out.println(daoCategory.get(1));
        System.out.println(daoCategory.get("Update Discount")); // If repeated name select the last.
        System.out.println(daoCategory.get("The Test Discount")); // If repeated name select the last.
        // All
        System.out.println(daoCategory.getAll());*/

    }
}

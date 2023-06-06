package com.solvd;

import com.solvd.sql.jdbc.*;
import com.solvd.sql.model.*;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        // CATEGORY
        System.out.println("\n--- CATEGORY ---\n");
        // Create
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category();
        category.setCategoryName("Pants");
        categoryDao.insert(category);
        category.setCategoryName("Electronics");
        categoryDao.insert(category);
        category.setCategoryName("Food");
        categoryDao.insert(category);
        // Update
        category.setCategoryName("Clothes"); // Needs to specify the ID
        category.setId(1);
        categoryDao.update(category);
        // Delete
        categoryDao.delete(3); // Delete Food
        // Read
        System.out.println(categoryDao.get(1));
        System.out.println(categoryDao.get("Electronics")); // If repeated name select the last.
        // All
        System.out.println(categoryDao.getAll());

        // PERSON
        System.out.println("\n--- PERSON ---\n");
        // Create
        PersonDao personDao = new PersonDao();
        Person person = new Person();
        person.setPersonName("Bart");
        person.setLastName("Simpson");
        person.setPhone("1234561235");
        person.setAddress("342 noway Springfield");
        personDao.insert(person);
        person.setPersonName("Tom");
        person.setLastName("Sawyer");
        person.setPhone("1234561236");
        person.setAddress("756 nowhere St. Petersburg Missouri");
        personDao.insert(person);
        person.setPersonName("Emma");
        person.setLastName("Watson");
        person.setPhone("1234561237");
        person.setAddress("342 somewhere Liverpool, England");
        personDao.insert(person);
        person.setPersonName("Charlie");
        person.setLastName("Garcia");
        person.setPhone("1234561234");
        person.setAddress("234 brown street Los Angeles,CA");
        personDao.insert(person);
        person.setPersonName("Genghis");
        person.setLastName("Khan");
        person.setPhone("8569751246");
        person.setAddress("9832 cest' la vie Monrroe, 239843");
        personDao.insert(person);
        // Update
        person.setLastName("Brown"); // Needs to specify the ID
        person.setId(4);
        personDao.update(person);
        // Delete
        personDao.delete(5);
        // Read
        System.out.println(personDao.get(4));
        // All
        System.out.println(personDao.getAll());

        // CUSTOMER
        System.out.println("\n--- CUSTOMER ---\n");
        // Create
        CustomerDao customerDao = new CustomerDao();
        Customer customer = new Customer();
        customer.setTaxNumber("00000000");
        customer.setPersonId(4);
        customerDao.insert(customer);
        customer.setTaxNumber("274527252");
        customer.setPersonId(3);
        customerDao.insert(customer);
        // Update
        customer.setTaxNumber("1254986532"); // Needs to specify the ID
        customer.setPersonId(4);
        customer.setId(1);
        customerDao.update(customer);
        // Delete
        customerDao.delete(2);
        // Read
        System.out.println(customerDao.get(1));
        // All
        System.out.println(customerDao.getAll());

        // OWNER
        System.out.println("\n--- OWNER ---\n");
        // Create
        OwnerDao ownerDao = new OwnerDao();
        Owner owner = new Owner();
        owner.setPersonId(1);
        ownerDao.insert(owner);
        owner.setPersonId(2);
        ownerDao.insert(owner);
        // Update
        owner.setPersonId(3); // Needs to specify the ID
        owner.setId(1);
        ownerDao.update(owner);
        // Delete
        ownerDao.delete(2);
        // Read
        System.out.println(ownerDao.get(1));
        // All
        System.out.println(ownerDao.getAll());

        // SHOP
        System.out.println("\n--- SHOP ---\n");
        // Create
        ShopDao shopDao = new ShopDao();
        Shop shop = new Shop();
        shop.setShopName("Le Sportif Foe");
        shop.setAddress("In a land far far away");
        shop.setPhone("1120984567");
        shop.setOwnerId(1);
        shopDao.insert(shop);
        shop.setShopName("Federico Barba Roja");
        shop.setAddress("In between dreams");
        shop.setPhone("4593217865");
        shop.setOwnerId(1);
        shopDao.insert(shop);
        // Update
        shop.setShopName("La Tasca");
        shop.setAddress("In a land far far away");
        shop.setPhone("1120984567");
        shop.setId(1);
        shopDao.update(shop);
        // Delete
        shopDao.delete(2);
        // Read
        System.out.println(shopDao.get(1));
        // All
        System.out.println(shopDao.getAll());

        // STAFF
        System.out.println("\n--- STAFF ---\n");
        // Create
        StaffDao staffDao = new StaffDao();
        Staff staff = new Staff();
        staff.setPosition("AllinOne");
        staff.setPersonId(2);
        staff.setShopId(1);
        staffDao.insert(staff);
        staff.setPosition("Worker");
        staff.setPersonId(1);
        staff.setShopId(1);
        staffDao.insert(staff);
        // Update
        staff.setPosition("Manager");
        staff.setPersonId(2);
        staff.setShopId(1);
        staff.setId(1);
        staffDao.update(staff);
        // Delete
        staffDao.delete(2);
        // Read
        System.out.println(staffDao.get(1));
        // All
        System.out.println(staffDao.getAll());

        // SUPPLIER
        System.out.println("\n--- SUPPLIER ---\n");
        // Create
        SupplierDao supplierDao = new SupplierDao();
        Supplier supplier = new Supplier();
        supplier.setSupplierName("Gucci");
        supplier.setTaxNumber("123455678");
        supplier.setPhone("2340981245");
        supplierDao.insert(supplier);
        supplier.setSupplierName("Tommy");
        supplier.setTaxNumber("123455678");
        supplier.setPhone("2340981245");
        supplierDao.insert(supplier);
        // Update
        supplier.setSupplierName("LaCoste");
        supplier.setTaxNumber("123455678");
        supplier.setPhone("2340981245");
        supplier.setId(1);
        supplierDao.update(supplier);
        // Delete
        supplierDao.delete(2);
        // Read
        System.out.println(supplierDao.get(1));
        // All
        System.out.println(supplierDao.getAll());

        // PRODUCT
        System.out.println("\n--- PRODUCT ---\n");
        // Create
        ProductDao productDao = new ProductDao();
        Product product = new Product();
        product.setProductName("Shirt");
        product.setStock(23);
        product.setPrice(60);
        product.setCategoryId(1);
        product.setSupplierId(1);
        productDao.insert(product);
        product.setProductName("Pants");
        product.setStock(13);
        product.setPrice(20);
        product.setCategoryId(1);
        product.setSupplierId(1);
        productDao.insert(product);
        product.setProductName("iPad");
        product.setStock(5);
        product.setPrice(2000);
        product.setCategoryId(2);
        product.setSupplierId(1);
        productDao.insert(product);
        // Update
        product.setProductName("Pants");
        product.setStock(13);
        product.setPrice(80);
        product.setCategoryId(1);
        product.setSupplierId(1);
        productDao.insert(product);
        product.setId(2);
        productDao.update(product);
        // Delete
        productDao.delete(3);
        // Read
        System.out.println(productDao.get(1));
        // All
        System.out.println(productDao.getAll());

        // ORDERS
        System.out.println("\n--- ORDERS ---\n");
        // Create
        OrdersDao ordersDao = new OrdersDao();
        Orders orders = new Orders();
        orders.setOrder_date(Date.valueOf(("2022-5-5")));
        orders.setTotal(80);
        orders.setCustomerId(1);
        ordersDao.insert(orders);
        orders.setOrder_date(Date.valueOf(("2022-4-5")));
        orders.setTotal(60);
        orders.setCustomerId(1);
        ordersDao.insert(orders);
        // Update
        orders.setOrder_date(Date.valueOf(("2022-5-5")));
        orders.setTotal(120);
        orders.setCustomerId(1);
        orders.setId(1);
        ordersDao.update(orders);
        // Delete
        ordersDao.delete(2);
        // Read
        System.out.println(ordersDao.get(1));
        // All
        System.out.println(ordersDao.getAll());

        // ORDERITEM
        System.out.println("\n--- ORDERITEM ---\n");
        // Create
        OrderItemDao orderItemDao = new OrderItemDao();
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(1);
        orderItem.setOrderId(1);
        orderItem.setProductId(1);
        orderItemDao.insert(orderItem);
        orderItem.setQuantity(1);
        orderItem.setOrderId(1);
        orderItem.setProductId(2);
        orderItemDao.insert(orderItem);
        // Update
        orderItem.setQuantity(2);
        orderItem.setOrderId(1);
        orderItem.setProductId(1);
        orderItemDao.update(orderItem);
        // Delete
        orderItemDao.delete(2);
        // Read
        System.out.println(orderItemDao.get(1));
        // All
        System.out.println(orderItemDao.getAll());

        // PROMOTION
        System.out.println("\n--- PROMOTION ---\n");
        // Create
        PromotionDao promotionDao = new PromotionDao();
        Promotion promotion = new Promotion();
        promotion.setPromotionName("Summer Discount");
        promotion.setDiscount(0.6F);
        promotion.setStartDate(Date.valueOf("2022-06-01"));
        promotion.setEndDate(Date.valueOf("2022-09-01"));
        promotionDao.insert(promotion);
        promotion.setPromotionName("Winter Discount");
        promotion.setDiscount(0.3F);
        promotion.setStartDate(Date.valueOf("2023-04-01"));
        promotion.setEndDate(Date.valueOf("2022-12-01"));
        promotionDao.insert(promotion);
        promotion.setPromotionName("Special Discount");
        promotion.setDiscount(0.9F);
        promotion.setStartDate(Date.valueOf("2022-01-01"));
        promotion.setEndDate(Date.valueOf("2022-12-31"));
        promotionDao.insert(promotion);
        // Update
        promotion.setDiscount(0.2F);
        promotion.setStartDate(Date.valueOf("2022-06-01"));
        promotion.setEndDate(Date.valueOf("2022-09-01"));
        promotion.setId(1);
        promotionDao.update(promotion);
        // Delete
        promotionDao.delete(3);
        // Read
        System.out.println(promotionDao.get(1));
        // All
        System.out.println(promotionDao.getAll());

        // PRODUCT PROMOTION
        System.out.println("\n--- PRODUCTPROMOTION ---\n");
        // Create
        ProductPromotionDao productPromotionDao = new ProductPromotionDao();
        ProductPromotion productPromotion = new ProductPromotion();
        productPromotion.setPromotionId(2);
        productPromotion.setProductId(1);
        productPromotionDao.insert(productPromotion);
        productPromotion.setPromotionId(1);
        productPromotion.setProductId(2);
        productPromotionDao.insert(productPromotion);
        // Update
        productPromotion.setPromotionId(1);
        productPromotion.setProductId(1); // update by product id
        productPromotionDao.update(productPromotion);
        // Delete
        productPromotionDao.delete(2);
        // Read
        System.out.println(productPromotionDao.get(1));
        // All
        System.out.println(productPromotionDao.getAll());
    }
}

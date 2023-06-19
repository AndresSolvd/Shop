package com.solvd;

import com.solvd.sql.model.*;
import com.solvd.sql.mybatis.*;

import java.sql.Date;

public class MyBatisMain {
    public static void main(String[] args) {

        // CATEGORY
        System.out.println("\nCategory");
        // test Print all
        System.out.println(new CategoryDao().getAll());
        // Insert
        Category category = new Category();
        category.setCategoryName("plants");
        new CategoryDao().insert(category);
        category.setCategoryName("candies");
        new CategoryDao().insert(category);
        // Print by id
        System.out.println(new CategoryDao().getById(1));
        // Print by name
        System.out.println(new CategoryDao().getByName("plants")); // Empty DB as repeated categories throw error
        // Print all
        System.out.println(new CategoryDao().getAll());
        // Update
        category = new CategoryDao().getById(1);
        category.setCategoryName("clothes");
        new CategoryDao().update(category);
        System.out.println(new CategoryDao().getById(1));
        // Delete
        new CategoryDao().delete(2);
        System.out.println(new CategoryDao().getAll());

        // PERSON
        System.out.println("\nPerson");
        // test
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
        person.setPersonName("Genghis");
        person.setLastName("Khan");
        person.setPhone("8569751246");
        person.setAddress(("9832 cest' la vie Monrroe, 239843"));
        personDao.insert(person);
        person.setPersonName("Groucho");
        person.setLastName("Marx");
        person.setPhone("515641621");
        person.setAddress(("Not Funny, but funny"));
        personDao.insert(person);
        // Print by id
        System.out.println(new PersonDao().getById(2));
        // Update
        person = new PersonDao().getById(2);
        person.setPersonName("Patricio");
        personDao.update(person);
        System.out.println(new PersonDao().getById(2));
        // Delete
        new PersonDao().delete(4);
        System.out.println(new PersonDao().getAll());

        // CUSTOMER
        System.out.println("\nCustomers");
        // test
        System.out.println(new CustomerDao().getAll());
        // Insert
        Customer customer = new Customer();
        customer.setTaxNumber("4532168");
        customer.setPerson(new PersonDao().getById(1));
        new CustomerDao().insert(customer);
        customer.setTaxNumber("65465155");
        customer.setPerson(new PersonDao().getById(2));
        new CustomerDao().insert(customer);
        // Print by id
        System.out.println(new CustomerDao().getById(1));
        // Update
        customer.setTaxNumber("55555555");
        new CustomerDao().update(customer);
        System.out.println(new CustomerDao().getById(1));
        // Delete
        new CustomerDao().delete(2);
        System.out.println(new CustomerDao().getAll());

        // OWNER
        System.out.println("\nOwner");
        //test
        System.out.println(new OwnerDao().getAll());
        //Insert
        Owner owner = new Owner();
        owner.setPersonId(1);
        new OwnerDao().insert(owner);
        owner.setPersonId(2);
        new OwnerDao().insert(owner);
        System.out.println(new OwnerDao().getAll());
        // Print by id
        System.out.println(new OwnerDao().getById(1));
        // Update
        owner.setPersonId(3);
        owner.setId(1);
        new OwnerDao().update(owner);
        System.out.println(new OwnerDao().getById(1));
        // Delete
        new OwnerDao().delete(2);
        System.out.println(new OwnerDao().getAll());

        // SHOP
        System.out.println("\nShop");
        //test
        System.out.println(new ShopDao().getAll());
        //Insert
        Shop shop = new Shop();
        shop.setShopName("Le Sportif Foe");
        shop.setAddress("In a land far far away");
        shop.setPhone("1120984567");
        shop.setOwnerId(1);
        new ShopDao().insert(shop);
        shop.setShopName("Federico Barba Roja");
        shop.setAddress("In between dreams");
        shop.setPhone("4593217865");
        shop.setOwnerId(1);
        new ShopDao().insert(shop);
        System.out.println(new ShopDao().getAll());
        // Print by id
        System.out.println(new ShopDao().getById(1));
        // Update
        shop.setShopName("La Tasca");
        shop.setAddress("In a land far far away");
        shop.setPhone("1120984567");
        shop.setId(1);
        new ShopDao().update(shop);
        System.out.println(new ShopDao().getById(1));
        //Delete
        new ShopDao().delete(2);
        System.out.println(new ShopDao().getAll());

        // STAFF
        System.out.println("\nStaff");
        //test
        System.out.println(new StaffDao().getAll());
        //Insert
        Staff staff = new Staff();
        staff.setPosition("AllinOne");
        staff.setPersonId(2);
        staff.setShopId(1);
        new StaffDao().insert(staff);
        staff.setPosition("Worker");
        staff.setPersonId(1);
        staff.setShopId(1);
        new StaffDao().insert(staff);
        System.out.println(new StaffDao().getAll());
        // Print by id
        System.out.println(new StaffDao().getById(1));
        // Update
        staff.setPosition("Manager");
        staff.setPersonId(2);
        staff.setShopId(1);
        staff.setId(1);
        new StaffDao().update(staff);
        System.out.println(new StaffDao().getById(1));
        //Delete
        new StaffDao().delete(2);
        System.out.println(new StaffDao().getAll());

        // SUPPLIER
        System.out.println("\nSupplier");
        //test
        System.out.println(new SupplierDao().getAll());
        //Insert
        Supplier supplier = new Supplier();
        supplier.setSupplierName("Gucci");
        supplier.setTaxNumber("123455678");
        supplier.setPhone("2340981245");
        new SupplierDao().insert(supplier);
        supplier.setSupplierName("Tommy");
        supplier.setTaxNumber("123455678");
        supplier.setPhone("2340981245");
        new SupplierDao().insert(supplier);
        System.out.println(new SupplierDao().getAll());
        // Print by id
        System.out.println(new SupplierDao().getById(1));
        // Update
        supplier.setSupplierName("LaCoste");
        supplier.setTaxNumber("123455678");
        supplier.setPhone("2340981245");
        supplier.setId(1);
        new SupplierDao().update(supplier);
        System.out.println(new SupplierDao().getById(1));
        //Delete
        new StaffDao().delete(2);
        System.out.println(new SupplierDao().getAll());

        // PRODUCT
        System.out.println("\nProduct");
        //test
        System.out.println(new ProductDao().getAll());
        //Insert
        Product product = new Product();
        product.setProductName("Shirt");
        product.setStock(23);
        product.setPrice(60);
        product.setCategoryId(1);
        product.setSupplierId(1);
        new ProductDao().insert(product);
        product.setProductName("Pants");
        product.setStock(13);
        product.setPrice(20);
        product.setCategoryId(1);
        product.setSupplierId(1);
        new ProductDao().insert(product);
        product.setProductName("iPad");
        product.setStock(5);
        product.setPrice(2000);
        product.setCategoryId(1);
        product.setSupplierId(1);
        new ProductDao().insert(product);
        System.out.println(new ProductDao().getAll());
        // Print by id
        System.out.println(new ProductDao().getById(1));
        // Update
        product.setProductName("Pants");
        product.setStock(13);
        product.setPrice(80);
        product.setCategoryId(1);
        product.setSupplierId(1);
        product.setId(2);
        new ProductDao().update(product);
        System.out.println(new ProductDao().getById(1));
        //Delete
        new StaffDao().delete(3);
        System.out.println(new ProductDao().getAll());

        // ORDERS
        System.out.println("\nOrders");
        //test
        System.out.println(new OrdersDao().getAll());
        //Insert
        Orders orders = new Orders();
        orders.setOrderDate(Date.valueOf(("2022-5-5")));
        orders.setTotal(80);
        orders.setCustomerId(1);
        new OrdersDao().insert(orders);
        orders.setOrderDate(Date.valueOf(("2022-4-5")));
        orders.setTotal(60);
        orders.setCustomerId(1);
        new OrdersDao().insert(orders);
        System.out.println(new OrdersDao().getAll());
        // Print by id
        System.out.println(new OrdersDao().getById(1));
        // Update
        orders.setOrderDate(Date.valueOf(("2022-5-5")));
        orders.setTotal(120);
        orders.setCustomerId(1);
        orders.setId(1);
        new OrdersDao().update(orders);
        System.out.println(new OrdersDao().getById(1));
        //Delete
        new StaffDao().delete(2);
        System.out.println(new OrdersDao().getAll());

        // ORDER ITEM
        System.out.println("\nOrder Item");
        //test
        System.out.println(new OrderItemDao().getAll());
        //Insert
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(1);
        orderItem.setOrderId(1);
        orderItem.setProductId(1);
        new OrderItemDao().insert(orderItem);
        orderItem.setQuantity(1);
        orderItem.setOrderId(2);
        orderItem.setProductId(2);
        new OrderItemDao().insert(orderItem);
        System.out.println(new OrderItemDao().getAll());
        // Print by id
        System.out.println(new OrderItemDao().getById(1));
        // Update
        orderItem.setQuantity(2);
        orderItem.setOrderId(1);
        orderItem.setProductId(1);
        new OrderItemDao().update(orderItem);
        System.out.println(new OrderItemDao().getById(1));
        //Delete
        new StaffDao().delete(2);
        System.out.println(new OrderItemDao().getAll());

        // PROMOTION
        System.out.println("\nPromotion");
        //test
        System.out.println(new PromotionDao().getAll());
        //Insert
        Promotion promotion = new Promotion();
        promotion.setPromotionName("Summer Discount");
        promotion.setDiscount(0.6F);
        promotion.setStartDate(Date.valueOf("2022-06-01"));
        promotion.setEndDate(Date.valueOf("2022-09-01"));
        new PromotionDao().insert(promotion);
        promotion.setPromotionName("Winter Discount");
        promotion.setDiscount(0.3F);
        promotion.setStartDate(Date.valueOf("2023-04-01"));
        promotion.setEndDate(Date.valueOf("2022-12-01"));
        new PromotionDao().insert(promotion);
        promotion.setPromotionName("Special Discount");
        promotion.setDiscount(0.9F);
        promotion.setStartDate(Date.valueOf("2022-01-01"));
        promotion.setEndDate(Date.valueOf("2022-12-31"));
        new PromotionDao().insert(promotion);
        System.out.println(new PromotionDao().getAll());
        // Print by id
        System.out.println(new PromotionDao().getById(1));
        // Update
        promotion.setDiscount(0.2F);
        promotion.setStartDate(Date.valueOf("2022-06-01"));
        promotion.setEndDate(Date.valueOf("2022-09-01"));
        promotion.setId(1);
        System.out.println(new PromotionDao().getById(1));
        //Delete
        new StaffDao().delete(2);
        System.out.println(new PromotionDao().getAll());

        // PRODUCT PROMOTION
        System.out.println("\nProduct Promotion");
        //test
        System.out.println(new ProductPromotionDao().getAll());
        //Insert
        ProductPromotion productPromotion = new ProductPromotion();
        productPromotion.setPromotionId(2);
        productPromotion.setProductId(1);
        new ProductPromotionDao().insert(productPromotion);
        productPromotion.setPromotionId(1);
        productPromotion.setProductId(2);
        new ProductPromotionDao().insert(productPromotion);
        System.out.println(new ProductPromotionDao().getAll());
        // Print by id
        System.out.println(new ProductPromotionDao().getById(1));
        // Update
        productPromotion.setPromotionId(1);
        productPromotion.setProductId(1); // update by product id
        new ProductPromotionDao().update(productPromotion);
        System.out.println(new ProductPromotionDao().getById(1));
        //Delete
        new StaffDao().delete(2);
        System.out.println(new ProductPromotionDao().getAll());
    }
}

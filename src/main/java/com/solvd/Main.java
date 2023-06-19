package com.solvd;

import com.solvd.enums.Paths;
import com.solvd.sql.jackson.JSONUtils;
import com.solvd.sql.jaxb.JAXBUtils;
import com.solvd.sql.model.*;
import com.solvd.sql.mybatis.*;
import com.solvd.sql.services.*;
import com.solvd.util.XmlParser;
import com.solvd.util.XmlValidator;

import javax.xml.bind.JAXBException;
import java.sql.Date;

public class Main {
    public static void main(String[] args) throws JAXBException {

        // CATEGORY
        System.out.println("\n--- CATEGORY ---\n");
        // Create
        CategoryService categoryService = new CategoryService();
        Category category = new Category();
        category.setCategoryName("Pants");
        categoryService.insert(category);
        category.setCategoryName("Electronics");
        categoryService.insert(category);
        category.setCategoryName("Food");
        categoryService.insert(category);
        // Update
        category.setCategoryName("Clothes"); // Needs to specify the ID
        category.setId(1);
        categoryService.update(category);
        // Delete
        categoryService.delete(3); // Delete Food
        // Read
        System.out.println(categoryService.getById(1));
        System.out.println(categoryService.getByName("Electronics")); // If repeated name select the last.
        // All
        System.out.println(categoryService.getAll());

        // PERSON
        System.out.println("\n--- PERSON ---\n");
        // Create
        PersonService personService = new PersonService();
        Person person = new Person();
        person.setPersonName("Bart");
        person.setLastName("Simpson");
        person.setPhone("1234561235");
        person.setAddress("342 noway Springfield");
        personService.insert(person);
        person.setPersonName("Tom");
        person.setLastName("Sawyer");
        person.setPhone("1234561236");
        person.setAddress("756 nowhere St. Petersburg Missouri");
        personService.insert(person);
        person.setPersonName("Emma");
        person.setLastName("Watson");
        person.setPhone("1234561237");
        person.setAddress("342 somewhere Liverpool, England");
        personService.insert(person);
        person.setPersonName("Charlie");
        person.setLastName("Garcia");
        person.setPhone("1234561234");
        person.setAddress("234 brown street Los Angeles,CA");
        personService.insert(person);
        person.setPersonName("Genghis");
        person.setLastName("Khan");
        person.setPhone("8569751246");
        person.setAddress("9832 cest' la vie Monrroe, 239843");
        personService.insert(person);
        // Update
        person.setLastName("Brown"); // Needs to specify the ID
        person.setId(4);
        personService.update(person);
        // Delete
        personService.delete(5);
        // Read
        System.out.println(personService.getById(4));
        // All
        System.out.println(personService.getAll());
        System.out.println(personService.getByName("Bart"));

        // CUSTOMER
        System.out.println("\n--- CUSTOMER ---\n");
        // Create
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer();
        customer.setTaxNumber("00000000");
        customer.setPerson(personService.getById(4));
        customerService.insert(customer);
        customer.setTaxNumber("274527252");
        customer.setPerson(personService.getById(3));
        customerService.insert(customer);
        customer.setTaxNumber("274527252");
        customer.setPerson(personService.getById(1));
        customerService.insert(customer);
        // Update
        customer.setTaxNumber("1254986532"); // Needs to specify the ID
        customer.setPerson(personService.getById(4));
        customer.setId(1);
        customerService.update(customer);
        // Delete
        customerService.delete(3);
        // Read
        System.out.println(customerService.getById(1));
        // All
        System.out.println(customerService.getAll());
        System.out.println(customerService.getByName("Genghis"));

        // OWNER
        System.out.println("\n--- OWNER ---\n");
        // Create
        OwnerService ownerService = new OwnerService();
        Owner owner = new Owner();
        owner.setPerson(personService.getById(1));
        ownerService.insert(owner);
        owner.setPerson(personService.getById(2));
        ownerService.insert(owner);
        // Update
        owner.setPerson(personService.getById(1));// Needs to specify the ID
        owner.setId(1);
        ownerService.update(owner);
        // Delete
        ownerService.delete(2);
        // Read
        System.out.println(ownerService.getById(1));
        // All
        System.out.println(ownerService.getAll());
        System.out.println(ownerService.getByName("Bart"));

        // SHOP
        System.out.println("\n--- SHOP ---\n");
        // Create
        ShopService shopService = new ShopService();
        Shop shop = new Shop();
        shop.setShopName("Le Sportif Foe");
        shop.setAddress("In a land far far away");
        shop.setPhone("1120984567");
        shop.setOwner(ownerService.getById(1));
        shopService.insert(shop);
        shop.setShopName("Federico Barba Roja");
        shop.setAddress("In between dreams");
        shop.setPhone("4593217865");
        shop.setOwner(ownerService.getById(1));
        shopService.insert(shop);
        // Update
        shop.setShopName("La Tasca");
        shop.setAddress("In a land far far away");
        shop.setPhone("1120984567");
        shop.setId(1);
        shopService.update(shop);
        // Delete
        shopService.delete(2);
        // Read
        System.out.println(shopService.getById(1));
        // All
        System.out.println(shopService.getAll());

        // STAFF
        System.out.println("\n--- STAFF ---\n");
        // Create
        StaffService staffService = new StaffService();
        Staff staff = new Staff();
        staff.setPosition("AllinOne");
        staff.setPerson(personService.getById(2));
        staff.setShop(shopService.getById(1));
        staffService.insert(staff);
        staff.setPosition("Worker");
        staff.setPerson(personService.getById(1));
        staff.setShop(shopService.getById(1));
        staffService.insert(staff);
        // Update
        staff.setPosition("Manager");
        staff.setPerson(personService.getById(2));
        staff.setShop(shopService.getById(1));
        staff.setId(1);
        staffService.update(staff);
        // Delete
        staffService.delete(2);
        // Read
        System.out.println(staffService.getById(1));
        // All
        System.out.println(staffService.getAll());

        // SUPPLIER
        System.out.println("\n--- SUPPLIER ---\n");
        // Create
        SupplierService supplierService = new SupplierService();
        Supplier supplier = new Supplier();
        supplier.setSupplierName("Gucci");
        supplier.setTaxNumber("123455678");
        supplier.setPhone("2340981245");
        supplierService.insert(supplier);
        supplier.setSupplierName("Tommy");
        supplier.setTaxNumber("123455678");
        supplier.setPhone("2340981245");
        supplierService.insert(supplier);
        // Update
        supplier.setSupplierName("LaCoste");
        supplier.setTaxNumber("123455678");
        supplier.setPhone("2340981245");
        supplier.setId(1);
        supplierService.update(supplier);
        // Delete
        supplierService.delete(2);
        // Read
        System.out.println(supplierService.getById(1));
        // All
        System.out.println(supplierService.getAll());

        // PRODUCT
        System.out.println("\n--- PRODUCT ---\n");
        // Create
        ProductService productService = new ProductService();
        Product product = new Product();
        product.setProductName("Shirt");
        product.setStock(23);
        product.setPrice(60);
        product.setCategory(categoryService.getById(1));
        product.setSupplier(supplierService.getById(1));
        productService.insert(product);
        product.setProductName("Pants");
        product.setStock(13);
        product.setPrice(20);
        product.setCategory(categoryService.getById(1));
        product.setSupplier(supplierService.getById(1));
        productService.insert(product);
        product.setProductName("iPad");
        product.setStock(5);
        product.setPrice(2000);
        product.setCategory(categoryService.getById(2));
        product.setSupplier(supplierService.getById(1));
        productService.insert(product);
        // Update
        product.setProductName("Pants");
        product.setStock(13);
        product.setPrice(80);
        product.setCategory(categoryService.getById(1));
        product.setSupplier(supplierService.getById(1));
        product.setId(2);
        productService.update(product);
        // Delete
        productService.delete(3);
        // Read
        System.out.println(productService.getById(1));
        // All
        System.out.println(productService.getAll());

        // ORDERS
        System.out.println("\n--- ORDERS ---\n");
        // Create
        OrdersService ordersService = new OrdersService();
        Orders orders = new Orders();
        orders.setOrderDate(Date.valueOf(("2022-5-5")));
        orders.setTotal(80);
        orders.setCustomer(customerService.getById(1));
        ordersService.insert(orders);
        orders.setOrderDate(Date.valueOf(("2022-4-5")));
        orders.setTotal(60);
        orders.setCustomer(customerService.getById(2));
        ordersService.insert(orders);
        orders.setOrderDate(Date.valueOf(("2022-4-8")));
        orders.setTotal(78);
        orders.setCustomer(customerService.getById(1));
        ordersService.insert(orders);
        // Update
        orders.setOrderDate(Date.valueOf(("2022-5-5")));
        orders.setTotal(120);
        orders.setCustomer(customerService.getById(1));
        orders.setId(1);
        ordersService.update(orders);
        // Delete
        ordersService.delete(3);
        // Read
        System.out.println(ordersService.getById(1));
        // All
        System.out.println(ordersService.getAll());
        System.out.println(ordersService.getByCustomerName("Genghis"));

        // ORDER ITEM
        System.out.println("\n--- ORDER ITEM ---\n");
        // Create
        OrderItemService orderItemService = new OrderItemService();
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(1);
        orderItem.setOrder(new OrdersDao().getById(1));
        orderItem.setProduct(new ProductDao().getById(1));
        orderItemService.insert(orderItem);
        orderItem.setQuantity(1);
        orderItem.setOrder(new OrdersDao().getById(2));
        orderItem.setProduct(new ProductDao().getById(2));
        orderItemService.insert(orderItem);
        // Update
        orderItem.setQuantity(2);
        orderItem.setOrder(new OrdersDao().getById(1));
        orderItem.setProduct(new ProductDao().getById(1));
        orderItemService.update(orderItem);
        // Delete
        orderItemService.delete(2);
        // Read
        System.out.println(orderItemService.getById(1));
        // All
        System.out.println(orderItemService.getAll());
        System.out.println(orderItemService.getByProductName("Shirt")); // only first incidence

        // PROMOTION
        System.out.println("\n--- PROMOTION ---\n");
        // Create
        PromotionService promotionService = new PromotionService();
        Promotion promotion = new Promotion();
        promotion.setPromotionName("Summer Discount");
        promotion.setDiscount(0.6F);
        promotion.setStartDate(Date.valueOf("2022-06-01"));
        promotion.setEndDate(Date.valueOf("2022-09-01"));
        promotionService.insert(promotion);
        promotion.setPromotionName("Winter Discount");
        promotion.setDiscount(0.3F);
        promotion.setStartDate(Date.valueOf("2023-04-01"));
        promotion.setEndDate(Date.valueOf("2022-12-01"));
        promotionService.insert(promotion);
        promotion.setPromotionName("Special Discount");
        promotion.setDiscount(0.9F);
        promotion.setStartDate(Date.valueOf("2022-01-01"));
        promotion.setEndDate(Date.valueOf("2022-12-31"));
        promotionService.insert(promotion);
        // Update
        promotion.setDiscount(0.2F);
        promotion.setStartDate(Date.valueOf("2022-06-01"));
        promotion.setEndDate(Date.valueOf("2022-09-01"));
        promotion.setId(1);
        promotionService.update(promotion);
        // Delete
        promotionService.delete(3);
        // Read
        System.out.println(promotionService.getById(1));
        // All
        System.out.println(promotionService.getAll());

        // PRODUCT PROMOTION
        System.out.println("\n--- PRODUCT PROMOTION ---\n");
        // Create
        ProductPromotionService productPromotionService = new ProductPromotionService();
        ProductPromotion productPromotion = new ProductPromotion();
        productPromotion.setPromotion(promotionService.getById(2));
        productPromotion.setProduct(productService.getById(1));
        productPromotionService.insert(productPromotion);
        productPromotion.setPromotion(promotionService.getById(1));
        productPromotion.setProduct(productService.getById(2));
        productPromotionService.insert(productPromotion);
        // Update
        productPromotion.setPromotion(promotionService.getById(1));
        productPromotion.setProduct(productService.getById(1));     // update by product id
        productPromotionService.update(productPromotion);
        // Delete
        productPromotionService.delete(2);
        // Read
        System.out.println(productPromotionService.getById(1));
        // All
        System.out.println(productPromotionService.getAll());

        // XML Validate and Parse
        System.out.println("\n--- XML Validation and Parse ---\n");
        XmlValidator.validateXMLAgainstXSD(Paths.SHOPXML.getPath(), Paths.SHOPXSD.getPath());
        System.out.println(XmlParser.parseShopDataFromFile(Paths.SHOPXML.getPath()));

        // Marsh and UnMarsh Person
        System.out.println("\n--- File create from Person Object is stored in resources/xml --- ");
        JAXBUtils.marshall(person);
        System.out.println("\n--- Unmarshall Person.xml file --- ");
        System.out.println(JAXBUtils.unMarshall(Paths.XMLFOLDER.getPath() + "Person.xml"));

        // JSON
        System.out.println("\n ---JSON--- ");
        JSONUtils.writeJSON(shop);
        JSONUtils.writeJSON(person);
        JSONUtils.writeJSON(customer);
        JSONUtils.writeJSON(product);
        JSONUtils.writeJSON(promotion);
        JSONUtils.writeJSON(orders);
        System.out.println(JSONUtils.readJSON("shop"));
        System.out.println(JSONUtils.readJSON("person"));
        System.out.println(JSONUtils.readJSON("customer"));
        System.out.println(JSONUtils.readJSON("product"));
        System.out.println(JSONUtils.readJSON("promotion"));
        System.out.println(JSONUtils.readJSON("orders"));
    }
}

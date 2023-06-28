package com.solvd;

import com.solvd.enums.Paths;
import com.solvd.sql.jackson.JSONUtils;
import com.solvd.sql.jaxb.JAXBUtils;
import com.solvd.sql.model.*;
import com.solvd.sql.mybatis.OrderDao;
import com.solvd.sql.mybatis.ProductDao;
import com.solvd.sql.services.*;
import com.solvd.util.SqlResetUtil;
import com.solvd.util.XmlParser;
import com.solvd.util.XmlValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.sql.Date;

public class Main {
    public static void main(String[] args) throws JAXBException {

        final Logger LOGGER = LogManager.getLogger(Main.class);

        // Reset All Tables
        SqlResetUtil.reset();

        // CATEGORY
        LOGGER.info("\n--- CATEGORY ---\n");
        // Create
        CategoryService categoryService = new CategoryService();
        categoryService.insert(new Category.Builder().withCategoryName("Pants").build());
        categoryService.insert(new Category.Builder().withCategoryName("Electronics").build());
        categoryService.insert(new Category.Builder().withCategoryName("Food").build());
        // Update
        categoryService.update(new Category.Builder().withId(1).withCategoryName("Clothes").build()); // Needs to specify the ID
        // Delete
        categoryService.delete(3); // Delete Food
        // Read
        LOGGER.info(categoryService.getById(1));
        LOGGER.info(categoryService.getCategoryByName("Electronics")); // If repeated name select the last.
        // All
        LOGGER.info(categoryService.getAll());

        // PERSON
        LOGGER.info("\n--- PERSON ---\n");
        // Create
        PersonService personService = new PersonService();
        personService.insert(new Person.Builder().withPersonName("Bart").withLastName("Simpson").withPhone("1234561235").withAddress("342 noway Springfield").build());
        personService.insert(new Person.Builder().withPersonName("Tom").withLastName("Sawyer").withPhone("1234561236").withAddress("756 nowhere St. Petersburg Missouri").build());
        personService.insert(new Person.Builder().withPersonName("Emma").withLastName("Watson").withPhone("1234561237").withAddress("342 somewhere Liverpool, England").build());
        personService.insert(new Person.Builder().withPersonName("Charlie").withLastName("Garcia").withPhone("1234561234").withAddress("234 brown street Los Angeles,CA").build());
        personService.insert(new Person.Builder().withPersonName("Genghis").withLastName("Khan").withPhone("8569751246").withAddress("9832 cest' la vie Monroe, 239843").build());
        // Update
        Person person = new PersonService().getById(4);
        person.setLastName("Brown");
        personService.update(person);
        // Delete
        personService.delete(5);
        // Read
        LOGGER.info(personService.getById(4));
        // All
        LOGGER.info(personService.getAll());
        LOGGER.info(personService.getPersonByName("Bart"));

        // CUSTOMER
        LOGGER.info("\n--- CUSTOMER ---\n");
        // Create
        CustomerService customerService = new CustomerService();
        customerService.insert(new Customer.Builder().withTaxNumber("00000000").withPerson(personService.getById(2)).build());
        customerService.insert(new Customer.Builder().withTaxNumber("274527252").withPerson(personService.getById(3)).build());
        customerService.insert(new Customer.Builder().withTaxNumber("274527252").withPerson(personService.getById(1)).build());
        // Update
        customerService.update(new Customer.Builder().withTaxNumber("1254986532").withPerson(personService.getById(4)).withId(1).build());
        // Delete
        customerService.delete(3);
        // Read
        LOGGER.info(customerService.getById(1));
        // All
        LOGGER.info(customerService.getAll());
        LOGGER.info(customerService.getCustomerByName("Genghis"));

        // OWNER
        LOGGER.info("\n--- OWNER ---\n");
        // Create
        OwnerService ownerService = new OwnerService();
        ownerService.insert(new Owner.Builder().withPerson(personService.getById(1)).build());
        ownerService.insert(new Owner.Builder().withPerson(personService.getById(2)).build());
        // Update
        Owner owner = ownerService.getById(1);
        owner.setPerson(personService.getById(1));// Needs to specify the ID
        ownerService.update(owner);
        // Delete
        ownerService.delete(2);
        // Read
        LOGGER.info(ownerService.getById(1));
        // All
        LOGGER.info(ownerService.getAll());
        LOGGER.info(ownerService.getOwnerByName("Bart"));

        // SHOP
        LOGGER.info("\n--- SHOP ---\n");
        // Create
        ShopService shopService = new ShopService();
        shopService.insert(new Shop.Builder().withShopName("Le Sportif Foe").withAddress("In a land far far away").withPhone("1120984567").withOwner(ownerService.getById(1)).build());
        shopService.insert(new Shop.Builder().withShopName("Federico Barba Roja").withAddress("In between dreams").withPhone("4593217865").withOwner(ownerService.getById(1)).build());
        // Update
        Shop shop = shopService.getById(1);
        shop.setShopName("La Tasca");
        shopService.update(shop);
        // Delete
        shopService.delete(2);
        // Read
        LOGGER.info(shopService.getById(1));
        // All
        LOGGER.info(shopService.getAll());
        LOGGER.info(shopService.getShopByName("La Tasca"));

        // STAFF
        LOGGER.info("\n--- STAFF ---\n");
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
        LOGGER.info(staffService.getById(1));
        // All
        LOGGER.info(staffService.getAll());
        LOGGER.info(staffService.getStaffByName("Tom"));

        // SUPPLIER
        LOGGER.info("\n--- SUPPLIER ---\n");
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
        LOGGER.info(supplierService.getById(1));
        // All
        LOGGER.info(supplierService.getAll());
        LOGGER.info(supplierService.getSupplierByName("LaCoste"));

        // PRODUCT
        LOGGER.info("\n--- PRODUCT ---\n");
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
        LOGGER.info(productService.getById(1));
        // All
        LOGGER.info(productService.getAll());
        LOGGER.info(productService.getProductByName("Shirt"));

        // ORDERS
        LOGGER.info("\n--- ORDERS ---\n");
        // Create
        OrderService orderService = new OrderService();
        Order order = new Order();
        order.setOrderDate(Date.valueOf(("2022-5-5")));
        order.setTotal(80);
        order.setCustomer(customerService.getById(1));
        orderService.insert(order);
        order.setOrderDate(Date.valueOf(("2022-4-5")));
        order.setTotal(60);
        order.setCustomer(customerService.getById(2));
        orderService.insert(order);
        order.setOrderDate(Date.valueOf(("2022-4-8")));
        order.setTotal(78);
        order.setCustomer(customerService.getById(1));
        orderService.insert(order);
        // Update
        order.setOrderDate(Date.valueOf(("2022-5-5")));
        order.setTotal(120);
        order.setCustomer(customerService.getById(1));
        order.setId(1);
        orderService.update(order);
        // Delete
        orderService.delete(3);
        // Read
        LOGGER.info(orderService.getById(1));
        // All
        LOGGER.info(orderService.getAll());
        LOGGER.info(orderService.getOrderByCustomerName("Genghis"));

        // ORDER ITEM
        LOGGER.info("\n--- ORDER ITEM ---\n");
        // Create
        OrderItemService orderItemService = new OrderItemService();
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(1);
        orderItem.setOrder(new OrderDao().getById(1));
        orderItem.setProduct(new ProductDao().getById(1));
        orderItemService.insert(orderItem);
        orderItem.setQuantity(1);
        orderItem.setOrder(new OrderDao().getById(2));
        orderItem.setProduct(new ProductDao().getById(2));
        orderItemService.insert(orderItem);
        // Update
        orderItem.setQuantity(2);
        orderItem.setOrder(new OrderDao().getById(1));
        orderItem.setProduct(new ProductDao().getById(1));
        orderItemService.update(orderItem);
        // Delete
        orderItemService.delete(2);
        // Read
        LOGGER.info(orderItemService.getById(1));
        // All
        LOGGER.info(orderItemService.getAll());
        LOGGER.info(orderItemService.getOrderByProductName("Shirt")); // only first incidence

        // PROMOTION
        LOGGER.info("\n--- PROMOTION ---\n");
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
        LOGGER.info(promotionService.getById(1));
        // All
        LOGGER.info(promotionService.getAll());
        LOGGER.info(promotionService.getPromotionByName("Special Discount"));

        // PRODUCT PROMOTION
        LOGGER.info("\n--- PRODUCT PROMOTION ---\n");
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
        LOGGER.info(productPromotionService.getById(1));
        // All
        LOGGER.info(productPromotionService.getAll());
        LOGGER.info(productPromotionService.getPromotionByProductName("Shirt"));

        // XML Validate and Parse
        LOGGER.info("\n--- XML Validation and Parse ---\n");
        XmlValidator.validateXMLAgainstXSD(Paths.SHOPXML.getPath(), Paths.SHOPXSD.getPath());
        LOGGER.info(XmlParser.parseShopDataFromFile(Paths.SHOPXML.getPath()));

        // Marsh and UnMarsh Person
        LOGGER.info("\n--- File create from Person Object is stored in resources/xml --- ");
        JAXBUtils.marshall(personService.getById(1));
        LOGGER.info("\n--- Unmarshall Person.xml file --- ");
        LOGGER.info(JAXBUtils.unMarshall(Paths.XMLFOLDER.getPath() + "Person.xml"));

        // JSON
        LOGGER.info("\n ---JSON--- ");
        JSONUtils.writeJSON(shop);
        JSONUtils.writeJSON(personService.getById(1));
        JSONUtils.writeJSON(customerService.getById(1));
        JSONUtils.writeJSON(product);
        JSONUtils.writeJSON(promotion);
        JSONUtils.writeJSON(order);
        LOGGER.info(JSONUtils.readJSON("shop"));
        LOGGER.info(JSONUtils.readJSON("person"));
        LOGGER.info(JSONUtils.readJSON("customer"));
        LOGGER.info(JSONUtils.readJSON("product"));
        LOGGER.info(JSONUtils.readJSON("promotion"));
        LOGGER.info(JSONUtils.readJSON("order"));
    }
}

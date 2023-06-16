-- DELETE
delete from order_item;
delete from orders;
delete from product_promotion;
delete from promotion;
delete from product;
delete from supplier;
delete from category;
delete from customer;
delete from staff;
delete from shop;
delete from owner;
delete from person;

-- ALTER
ALTER TABLE customer auto_increment = 1;
ALTER TABLE owner auto_increment = 1;
ALTER TABLE staff auto_increment = 1;
ALTER TABLE person auto_increment = 1;
ALTER TABLE shop auto_increment = 1;
ALTER TABLE category auto_increment = 1;
ALTER TABLE supplier auto_increment = 1;
ALTER TABLE orders auto_increment = 1;
ALTER TABLE promotion auto_increment = 1;
ALTER TABLE product auto_increment = 1;

-- INSERT 
-- INSERT 1 CATEGORY
INSERT INTO mydb.category(category_name) values('Clothes');
-- INSERT 4 PERSON
INSERT INTO person(person_name, last_name, phone, address) values('Bart', 'Simpson', '1234561235', '342 noway Springfield');
INSERT INTO person(person_name, last_name, phone, address) values('Tom', 'Sawyer', '1234561236', '756 nowhere St. Petersburg Missouri');
INSERT INTO person(person_name, last_name, phone, address) values('Emma', 'Watson', '1234561237', '342 somewhere Liverpool, England');
INSERT INTO person(person_name, last_name, phone, address) values ('Charlie', 'Garcia', '1234561234', '234 brown street Los Angeles,CA');
-- INSERT 1 CUSTOMER
INSERT INTO customer(tax_number, person_id) VALUES ('0987654321', (SELECT id FROM person WHERE person_name = 'Charlie' AND last_name = 'Garcia'));
-- INSERT 1 OWNER
INSERT INTO owner(person_id) values((SELECT id FROM person WHERE person_name = 'Emma' AND last_name = 'Watson'));
-- INSERT 1 SHOP
INSERT INTO shop(shop_name, address, phone, owner_id) values('Le Sportif Foe', 'In a land far far away', '1120984567', (SELECT id from owner WHERE person_id = (SELECT id FROM person WHERE person_name = 'Emma' AND last_name = 'Watson')));
-- INSERT 1 STAFF
INSERT INTO staff(position, person_id, shop_id) values('Manager', (SELECT id FROM person WHERE person_name = 'Tom' AND last_name = 'Sawyer'), (SELECT id FROM shop WHERE shop_name = 'Le Sportif Foe'));
-- INSERT SUPPLIER
INSERT INTO supplier(supplier_name, tax_number, phone) values('LaCoste', '123455678', '2340981245');
-- INSERT 2 PRODUCTS
INSERT INTO product(product_name, stock, price, category_id, supplier_id) values('Shirt', 23, 60, (SELECT id FROM category WHERE category_name = 'Clothes'), (SELECT id FROM supplier WHERE supplier_name = 'LaCoste'));
INSERT INTO product(product_name, stock, price, category_id, supplier_id) values('Pants', 13, 80, (SELECT id FROM category WHERE category_name = 'Clothes'), (SELECT id FROM supplier WHERE supplier_name = 'LaCoste'));
-- INSERT INTO ORDERS
INSERT INTO orders(order_date, total, customer_id) values('2022-05-05', 120, (SELECT id FROM customer WHERE person_id = (SELECT id FROM person WHERE person_name= 'Charlie' AND last_name = 'Garcia')));
-- INSERT ORDER_ITEM
INSERT INTO order_item (quantity, product_id, order_id) values(2, (SELECT id FROM product WHERE product_name = 'Shirt'), (SELECT id FROM orders WHERE customer_id = (SELECT id FROM customer WHERE person_id = (SELECT id FROM person WHERE person_name = 'Charlie' AND last_name = 'Garcia'))));
-- INSERT PROMOTION
INSERT INTO promotion(promotion_name, discount, start_date, end_date) values('Summer Discount', 0.2, '2022-06-01', '2022-09-01');
-- INSERT PRODUCT-PROMOTION
INSERT INTO product_promotion(promotion_id, product_id) VALUES((SELECT id FROM promotion WHERE promotion_name = 'Summer Discount'), (SELECT id from product WHERE product_name = 'Shirt') );

-- UPDATE
UPDATE person SET person_name = 'Homer' WHERE person_name = 'Bart';
UPDATE customer SET tax_number = '0987654367' WHERE  tax_number = '0987654321';
UPDATE orders SET total = 110 WHERE total = 120;
UPDATE order_item SET quantity = 3 WHERE quantity = 2;
UPDATE product SET price = 100 WHERE price = 60;
UPDATE product SET product_name = 'Jean' WHERE product_name = 'Pant';
UPDATE promotion SET discount = 0.3 WHERE discount = 0.2;
UPDATE shop SET shop_name = 'El deportista loco' WHERE shop_name = 'Le Sportif Foe';
UPDATE supplier SET phone = '123456789' WHERE phone = '2340981245';

-- 1 JOIN TABLE
-- 1 LEFT
SELECT * FROM person 
LEFT JOIN staff ON staff.person_id = person.id
LEFT JOIN owner ON owner.person_id = person.id
LEFT JOIN shop ON shop.owner_id = owner.id
LEFT JOIN customer ON customer.person_id = person.id 
LEFT JOIN orders ON orders.customer_id = customer.id
LEFT JOIN order_item ON order_item.order_id = orders.id
LEFT JOIN product ON product.id = order_item.product_id
LEFT JOIN category ON category.id = product.category_id
LEFT JOIN supplier ON supplier.id = product.supplier_id
LEFT JOIN product_promotion ON product_promotion.product_id = product.id
LEFT JOIN promotion ON promotion.id = product_promotion.promotion_id;
-- RIGHT
SELECT * FROM person 
RIGHT JOIN staff ON staff.person_id = person.id
RIGHT JOIN owner ON owner.person_id = person.id
RIGHT JOIN shop ON shop.owner_id = owner.id
RIGHT JOIN customer ON customer.person_id = person.id 
RIGHT JOIN orders ON orders.customer_id = customer.id
RIGHT JOIN order_item ON order_item.order_id = orders.id
RIGHT JOIN product ON product.id = order_item.product_id
RIGHT JOIN category ON category.id = product.category_id
RIGHT JOIN supplier ON supplier.id = product.supplier_id
RIGHT JOIN product_promotion ON product_promotion.product_id = product.id
RIGHT JOIN promotion ON promotion.id = product_promotion.promotion_id;


-- 5 JOIN LEFT/RIGHT - INNER/OUTER (left and right are outers and inner is implicit in JOIN).
-- RIGHT
SELECT * FROM person RIGHT JOIN customer ON person.id = customer.person_id;
-- LEFT
SELECT * FROM person LEFT JOIN customer ON person.id = customer.person_id;
-- INNER
SELECT * FROM person JOIN customer ON person.id = customer.person_id;
-- OTHERS 2
SELECT * FROM supplier INNER JOIN product ON supplier.id = product.supplier_id;
SELECT * FROM product_promotion INNER JOIN  product ON product.id = product_promotion.product_id INNER JOIN promotion ON promotion.id = product_promotion.promotion_id;

-- SALE updates the total price on order based on the inputs of quantity, price, discount, and name of customer
INSERT INTO orders (order_date, total, customer_id)
SELECT CURRENT_DATE(), (product.price * order_item.quantity * (1 - promotion.discount)) AS total, customer.id
FROM order_item
JOIN product ON product.id = order_item.product_id
JOIN product_promotion ON product_promotion.product_id = product.id
JOIN promotion ON promotion.id = product_promotion.promotion_id
JOIN orders ON orders.id = order_item.order_id
JOIN customer ON customer.id = orders.customer_id
JOIN person ON person.id = customer.person_id
WHERE person.person_name = 'Homer'
AND person.last_name = 'Simpson'
AND product.product_name = 'Shirt'
AND order_item.quantity = 2;
  
  -- 7 AGGREGATE FUNCTIONS WITHOUT HAVING
SELECT MIN(price) FROM product;
SELECT MAX(price) FROM product;
SELECT COUNT(price) FROM product;
SELECT SUM(price) FROM product;
SELECT AVG(price) FROM product;
SELECT COUNT(person_name) FROM person;
SELECT COUNT(supplier_name) FROM supplier;

-- 7 AGGREGATE FUNCTIONS WITH HAVING
SELECT product_name, stock FROM product GROUP BY product_name, stock HAVING stock < 15;
SELECT product_name, SUM(price) AS total_price FROM product GROUP BY product_name HAVING SUM(price) > 10;
SELECT total, SUM(total) FROM orders GROUP BY total HAVING SUM(total) > 50;
SELECT discount, MIN(discount) FROM promotion GROUP BY discount HAVING MIN(discount) < 10;
SELECT promotion_name, discount, MAX(discount) FROM promotion GROUP BY promotion_name, discount HAVING MAX(discount) > 0.1;
SELECT price, AVG(price) FROM product GROUP BY price HAVING AVG(price) > 90;
SELECT price, COUNT(price) FROM product GROUP BY price HAVING COUNT(price) < 90;

-- DELETE
DELETE FROM order_item WHERE quantity > 1;
DELETE FROM orders WHERE total > 20;
DELETE FROM customer WHERE person_id = (SELECT person_id FROM person WHERE person_name = 'Charlie' AND last_name = 'Garcia');
DELETE FROM person WHERE person_name = 'Charlie' AND last_name = 'Garcia';
DELETE FROM staff WHERE person_id = (SELECT person_id FROM person WHERE person_name = 'Tom' AND last_name = 'Sawyer');
DELETE FROM person WHERE person_name = 'Tom' AND last_name = 'Sawyer';
DELETE FROM product WHERE product_name = 'Jean';
DELETE FROM person WHERE person_name = 'Homer';
DELETE FROM promotion WHERE discount > 10;
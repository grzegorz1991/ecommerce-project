-- Replace the id here with the first user id you want to have ownership of the orders.
SET @userId1 = 7;
-- Replace the id here with the second user id you want to have ownership of the orders.
SET @userId2 = 8;

-- Delete existing data from tables
DELETE FROM web_order_quantity;
DELETE FROM web_order;
DELETE FROM inventory;
DELETE FROM product;
DELETE FROM address;
DELETE FROM local_user;

-- Insert sample products
INSERT INTO product (name, short_description, long_description, price) VALUES ('Product #1', 'Product one short description.', 'This is a very long description of product #1.', 5.50);
INSERT INTO product (name, short_description, long_description, price) VALUES ('Product #2', 'Product two short description.', 'This is a very long description of product #2.', 10.56);
INSERT INTO product (name, short_description, long_description, price) VALUES ('Product #3', 'Product three short description.', 'This is a very long description of product #3.', 2.74);
INSERT INTO product (name, short_description, long_description, price) VALUES ('Product #4', 'Product four short description.', 'This is a very long description of product #4.', 15.69);
INSERT INTO product (name, short_description, long_description, price) VALUES ('Product #5', 'Product five short description.', 'This is a very long description of product #5.', 42.59);

-- Retrieve the ids of the inserted products
SET @product1 = (SELECT id FROM product WHERE name = 'Product #1' LIMIT 1);
SET @product2 = (SELECT id FROM product WHERE name = 'Product #2' LIMIT 1);
SET @product3 = (SELECT id FROM product WHERE name = 'Product #3' LIMIT 1);
SET @product4 = (SELECT id FROM product WHERE name = 'Product #4' LIMIT 1);
SET @product5 = (SELECT id FROM product WHERE name = 'Product #5' LIMIT 1);

-- Insert sample inventory
INSERT INTO inventory (product_id, quantity) VALUES (@product1, 5);
INSERT INTO inventory (product_id, quantity) VALUES (@product2, 8);
INSERT INTO inventory (product_id, quantity) VALUES (@product3, 12);
INSERT INTO inventory (product_id, quantity) VALUES (@product4, 73);
INSERT INTO inventory (product_id, quantity) VALUES (@product5, 2);

-- Insert sample users
INSERT INTO local_user (username, password, email, first_name, last_name) VALUES ('user1', 'password1', 'user1@example.com', 'FirstName1', 'LastName1');
INSERT INTO local_user (username, password, email, first_name, last_name) VALUES ('user2', 'password2', 'user2@example.com', 'FirstName2', 'LastName2');

-- Retrieve the ids of the inserted users
SET @userId1 = (SELECT id FROM local_user WHERE username = 'user1' LIMIT 1);
SET @userId2 = (SELECT id FROM local_user WHERE username = 'user2' LIMIT 1);

-- Insert sample addresses
INSERT INTO address (address_line_1, city, country, user_id) VALUES ('123 Tester Hill', 'Testerton', 'England', @userId1);
INSERT INTO address (address_line_1, city, country, user_id) VALUES ('312 Spring Boot', 'Hibernate', 'England', @userId2);

-- Retrieve the ids of the inserted addresses
SET @address1 = (SELECT id FROM address WHERE user_id = @userId1 ORDER BY id DESC LIMIT 1);
SET @address2 = (SELECT id FROM address WHERE user_id = @userId2 ORDER BY id DESC LIMIT 1);

-- Insert sample orders
INSERT INTO web_order (address_id, user_id) VALUES (@address1, @userId1);
INSERT INTO web_order (address_id, user_id) VALUES (@address1, @userId1);
INSERT INTO web_order (address_id, user_id) VALUES (@address1, @userId1);
INSERT INTO web_order (address_id, user_id) VALUES (@address2, @userId2);
INSERT INTO web_order (address_id, user_id) VALUES (@address2, @userId2);

-- Retrieve the ids of the inserted orders
SET @order1 = (SELECT id FROM web_order WHERE address_id = @address1 AND user_id = @userId1 ORDER BY id DESC LIMIT 1);
SET @order2 = (SELECT id FROM web_order WHERE address_id = @address1 AND user_id = @userId1 ORDER BY id DESC LIMIT 1 OFFSET 1);
SET @order3 = (SELECT id FROM web_order WHERE address_id = @address1 AND user_id = @userId1 ORDER BY id DESC LIMIT 1 OFFSET 2);
SET @order4 = (SELECT id FROM web_order WHERE address_id = @address2 AND user_id = @userId2 ORDER BY id DESC LIMIT 1);
SET @order5 = (SELECT id FROM web_order WHERE address_id = @address2 AND user_id = @userId2 ORDER BY id DESC LIMIT 1 OFFSET 1);

-- Insert order quantities
INSERT INTO web_order_quantity (order_id, product_id, quantity) VALUES (@order1, @product1, 5);
INSERT INTO web_order_quantity (order_id, product_id, quantity) VALUES (@order1, @product2, 5);
INSERT INTO web_order_quantity (order_id, product_id, quantity) VALUES (@order2, @product3, 5);
INSERT INTO web_order_quantity (order_id, product_id, quantity) VALUES (@order2, @product2, 5);
INSERT INTO web_order_quantity (order_id, product_id, quantity) VALUES (@order2, @product5, 5);
INSERT INTO web_order_quantity (order_id, product_id, quantity) VALUES (@order3, @product3, 5);
INSERT INTO web_order_quantity (order_id, product_id, quantity) VALUES (@order4, @product4, 5);
INSERT INTO web_order_quantity (order_id, product_id, quantity) VALUES (@order4, @product2, 5);
INSERT INTO web_order_quantity (order_id, product_id, quantity) VALUES (@order5, @product3, 5);
INSERT INTO web_order_quantity (order_id, product_id, quantity) VALUES (@order5, @product1, 5);

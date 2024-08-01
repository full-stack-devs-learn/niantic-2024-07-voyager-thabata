-- Create a full script with variables that allows you 
-- to add a new Customer into the database. Then create an order for them
-- that includes 5 products. Create 5 variables at the top of the script
-- that store the 5 product names the customer wants to buy. You will use
-- the product names to find the id

-- Requirements
/*
    I should be able to run the script on my machine without having to
    write any queries to look up the id's of any tables. (The only id that
    I should have to know is the new CustomerId - which is a 5 letter code 
    that we will choose )

    Use variables at the top of the script to collect User Input. The rest 
    of the script should run without hardcoding ANY values.

    I.E. if I want to add a new customer, and order, I should be able 
    to change the variables at the beginning of the script, and run the whole
    script.
*/

/*
Customer must include: 
    Customer Id: 5 letter code
    Company Name: (You can use chatgpt or https://businessnamegenerator.com to pick a name)
    Contact Name: (you can use chatgpt or http://random-name-generator.info to pick a name)
    Address
    City
    Region
    Postal Code
    Country

Order:
    Order id: auto generated
    Customer Id: id from the inserted customer
    Order Date: today's date
    Ship Name: Contact name
    Ship Address: The company address information

OrderDetails: (Create 5 line items)
    Order Id: the one created above
    Product Id: use the product names to select/find the id of each product
    Unit Price: use the default list price of each product
    Quantity: you decide - between 1-10
    Discount: 0
*/

USE northwind;

-- VARIABLES add a new customer:
SET @customer_id = 'ABCDE';
SET @company_name = '13 Management';
SET @contact_name = 'Taylor Swift';
SET @address = '153 Franklin Street';
SET @city = 'New York';
SET @region = 'NY';
SET @postal_code = '10013';
SET @country = 'USA';

-- VARIABLES add products to be ordered:
SET @product_1_id = '19';
SET @product_2_id = '21';
SET @product_3_id = '25';
SET @product_4_id = '48';
SET @product_5_id = '68';

-- add new customer:
INSERT INTO customers (customer_id, company_name, contact_name, address, city, region, postal_code, country)
VALUES (@customer_id, @company_name, @contact_name, @address, @city, @region, @postal_code, @country);

-- add new order and generate order_id:
INSERT INTO orders (order_id, customer_id, order_date, ship_name, ship_address, ship_city, ship_region, ship_postal_code, ship_country)
VALUES (order_id, @customer_id, '2024-07-31 00:00:00', @contact_name, @address, @city, @region, @postal_code, @country);

-- to use the order_id created above:
SET @order_id = LAST_INSERT_ID();

-- didn't enter discount since it defaults to 0

-- product_1:
-- get the price:
SELECT unit_price INTO @unit_price FROM products WHERE product_id = @product_1_id;

INSERT INTO order_details (order_id, product_id, unit_price, quantity)
VALUES (@order_id, @product_1_id, @unit_price, 3);

-- product_2:
-- get the price:
SELECT unit_price INTO @unit_price FROM products WHERE product_id = @product_2_id;

INSERT INTO order_details (order_id, product_id, unit_price, quantity)
VALUES (@order_id, @product_2_id, @unit_price, 5);

-- product_3:
-- get the price:
SELECT unit_price INTO @unit_price FROM products WHERE product_id = @product_3_id;

INSERT INTO order_details (order_id, product_id, unit_price, quantity)
VALUES (@order_id, @product_3_id, @unit_price, 5);

-- product_4:
-- get the price:
SELECT unit_price INTO @unit_price FROM products WHERE product_id = @product_4_id;

INSERT INTO order_details (order_id, product_id, unit_price, quantity)
VALUES (@order_id, @product_4_id, @unit_price, 3);

-- product_5:
-- get the price:
SELECT unit_price INTO @unit_price FROM products WHERE product_id = @product_5_id;

INSERT INTO order_details (order_id, product_id, unit_price, quantity)
VALUES (@order_id, @product_5_id, @unit_price, 2);
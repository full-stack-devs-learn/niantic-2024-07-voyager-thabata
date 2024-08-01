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

-- DROP DATABASE IF EXISTS customer;
-- not sure I need this ^ 

-- CREATE DATABASE customer;
-- not sure I need this either ^

USE northwind;
-- ?? is this correct?

-- do I actually need to create the tables?!
CREATE TABLE customers
(
	customer_id CHAR(5) NOT NULL,
    company_name VARCHAR (50) NOT NULL,
    contact_name VARCHAR(50) NOT NULL,
    address VARCHAR(200) NOT NULL,
    city VARCHAR(50) NOT NULL,
    region VARCHAR(50) NOT NULL,
    postal_code INT(5) NOT NULL,
    country VARCHAR(50) NOT NULL
);

CREATE TABLE orders
(
	order_id INT AUTO_INCREMENT,
    product_id VARCHAR(50),
    unit_price INT (10),
    quantity INT(10),
    discount INT(5),
    order_date TIMESTAMP,
    ship_name VARCHAR(50),
    ship_address VARCHAR(200)
);

-- customer variables:
SET @customer_id = 'ABCDE';
SET @company_name = '13 Management';
SET @contact_name = 'Taylor Swift';
SET @address = "153 Franklin Street";
SET @city = 'New York';
SET @region = 'NY';
SET @postal_code = '10013';
SET @country = 'USA';

INSERT INTO customers (customer_id, company_name, contact_name, address, city, region, postal_code, country)
VALUES (@customer_id, @company_name, @contact_name, @address, @city, @region, @postal_code, @country);


-- order variables:
SET @order_id = '';
SET @customer_id = '';
SET @order_date = '';
SET ship_name = '';
SET ship_address = '';


-- order details variables:
SET @order_id = '';
SET @product_id = '';
SET @unit_price = '';
SET @quantity = '';
SET @discount = '';


INSERT INTO order (order_id, product_id, unit_price, quantity, discount)
VALUES 
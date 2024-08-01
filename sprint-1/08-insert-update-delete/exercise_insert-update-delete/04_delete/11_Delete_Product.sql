USE northwind;

-- delete one of your new sporting goods products
-- from the database
-- choose one that has not been purchased 

SELECT product_name
FROM products
WHERE product_id = 80;
-- ^ should I comment this test out? 

DELETE FROM products
WHERE product_id = 80;
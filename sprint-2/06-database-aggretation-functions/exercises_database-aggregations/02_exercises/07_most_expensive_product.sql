-- 7. Select the price of the most expensive product

-- (1 row)

USE northwind;

SELECT MAX(unit_price) AS most_expensive_product
FROM products;
USE northwind;

-- Write a script that updates the price of all products 
-- within a category by a certain percent.
-- use variables to accept the Category name and the percent increase 

SET @category_id = 9;
SET @percent_increase = 0.25;

UPDATE products
SET unit_price = unit_price * (@percent_increase)
WHERE category_id = @category_id;
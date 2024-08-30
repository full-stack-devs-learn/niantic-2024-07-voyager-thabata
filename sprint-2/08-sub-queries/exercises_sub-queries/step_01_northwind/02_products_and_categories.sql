-- 2. Create a product categories report

-- Columns to include:
-- ------------------
-- Category Name - CATEGORIES
-- Product Name - PRODUCTS
-- Unit Price - PRODUCTS


-- Use a sub query to display the Category Name
-- you are not allowed to use a JOIN statment

-- sort by category name, then product name

USE Northwind;

SELECT product_name
	, (
	SELECT category_name
	FROM categories AS c
	WHERE c.category_id = p.category_id
	) AS category_name
    , unit_price
    
FROM products AS p

ORDER BY category_name
	, product_name
-- 3.  List of all the categories 
-- that Alfreds Futterkiste has ever ordered
-- (5 rows)

USE Northwind;

SELECT DISTINCT p.category_id
	, cat.category_name
    
FROM categories AS cat

INNER JOIN products AS p
	ON cat.category_id = p.category_id
    
INNER JOIN order_details AS od
	ON p.product_id = od.product_id
    
INNER JOIN orders AS o
	ON od.order_id = o.order_id
    
INNER JOIN customers AS c
	ON o.customer_id = c.customer_id
    
WHERE c.company_name = "Alfreds Futterkiste";
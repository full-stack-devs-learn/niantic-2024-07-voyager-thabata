-- 4. I want to know what category is the most popular
-- category for my best customer.

-- SELECT the Company Name, Category, and the OrderCount
-- for Save-a-lot Markets. (my best customer)
-- (the order count specifies how many times a category
-- was included in their orders)

-- sort in the order of the most ordered category to the least

-- (8 rows)

USE northwind;

SELECT c.company_name
    , cat.category_name
	, COUNT(o.order_id) AS order_count
    
FROM categories AS cat

INNER JOIN products AS p
	ON cat.category_id = p.category_id
    
INNER JOIN order_details AS od
	ON p.product_id = od.product_id
    
INNER JOIN orders AS o
	ON od.order_id = o.order_id
    
INNER JOIN customers AS c
	ON c.customer_id = o.customer_id
    
WHERE company_name = "Save-a-lot Markets"

GROUP BY p.category_id, c.company_name

ORDER BY COUNT(o.order_id) DESC;
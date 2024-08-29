-- 5. The order details table includes the line item for each sale.
-- the Line Total is the SalesPrice * Quantity - Discount%.

-- I want a customer sales report
-- include customer names (compay_name), and their total sales amount (after discount)
-- sorted by sales total highest to lowest

-- The first 3 rows should be
-- CompanyName			SalesTotal
-- QUICK-Stop			110277.31
-- Ernst Handel			104874.98
-- Save-a-lot Markets	104361.95

-- (89 rows)

USE northwind;

SELECT DISTINCT c.company_name
	, SUM(od.unit_price * od.quantity) - SUM(od.unit_price * od.quantity * od.discount) AS sales_total
 
FROM order_details AS od

INNER JOIN orders AS o
	ON od.order_id = o.order_id

INNER JOIN customers AS c
	ON o.customer_id = c.customer_id

GROUP BY c.company_name
    
ORDER BY sales_total DESC
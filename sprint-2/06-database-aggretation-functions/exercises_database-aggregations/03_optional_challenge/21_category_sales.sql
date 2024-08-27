-- 21. Create a query that displays the top 3 most popular categories,
-- include:
    -- the total number of products that were purchased in that category (sum quantity),
    -- and the number of orders that were placed for each category (count unique orders)
-- (use the CustomerOrders View)

-- sort alphabetically by category name

-- expected results
-- ParentCategory	QuantityPurchased	OrdersPlaced
-- Beverages		9532				354
-- Dairy Products	9149				303
-- Confections		7906				295

-- (3 rows)

USE northwind;

SELECT category_name
	, SUM(quantity) AS quantity_purchased
	, COUNT(DISTINCT order_id) AS orders_placed
FROM customer_orders
GROUP BY category_id
ORDER BY SUM(quantity) DESC, category_name ASC
LIMIT 3;
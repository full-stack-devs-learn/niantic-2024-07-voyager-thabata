-- 12. The average line_item amount for all sales in the US
-- (Use the customer_orders view)
-- expect approx $748.77

-- (1 row)

USE northwind;

SELECT AVG((sales_price * quantity) - discount) AS average_sales_amount_usa
FROM customer_orders
WHERE country = "USA"
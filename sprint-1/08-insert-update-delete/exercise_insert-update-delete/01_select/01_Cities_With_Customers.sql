USE northwind;

-- Return all countries and cities where we 
-- have customers

-- Expected: 69 Rows

SELECT DISTINCT
	country
    , city
FROM customers
WHERE customer_id IS NOT null
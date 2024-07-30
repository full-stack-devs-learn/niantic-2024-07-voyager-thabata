USE northwind;

-- The employee name and title
-- of all employees who do not
-- have a boss

-- Expected: 1 row

SELECT 
	last_name
    , first_name
    , title
FROM employees
WHERE reports_to IS null
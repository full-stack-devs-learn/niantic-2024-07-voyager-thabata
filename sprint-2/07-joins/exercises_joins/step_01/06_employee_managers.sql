-- 6. Select the full name of each employee
-- and the full name of their manager

-- hint look at the employee table to see how to
-- determine who the manager is of each employee

-- you will need to do a "self join" to the employees table
-- and you will need to create table aliases to complete this query

-- (9 rows)

/*
SELECT A.employee_id AS employee
	, A.reports_to AS reports_to_id
    , B.employee_id AS manager

FROM employees A

LEFT JOIN employees B
	ON A.reports_to = B.employee_id;
*/    

USE northwind;
   
SELECT CONCAT(a.first_name, " ", a.last_name) AS employee
	, CONCAT(b.first_name, " ", b.last_name) AS manager
    
FROM employees a

LEFT JOIN employees b
	ON a.reports_to = b.employee_id
-- 8. Display the Category Name, and film title of all films
-- in the "Comedy" category

-- (58 rows)

USE sakila;

SELECT c.name AS category
	, f.title AS film

FROM film AS f

INNER JOIN film_category AS fc
	ON f.film_id = fc.film_id
    
INNER JOIN category AS c
	ON fc.category_id = c.category_id
    
WHERE c.name = "Comedy"
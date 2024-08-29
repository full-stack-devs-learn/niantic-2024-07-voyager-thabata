-- 9. Most Popular Film Categories
-- Return the total number of actors
-- who have acted in a category
-- sort most popular category to least

-- Columns: category_name, actor_count
--
-- (16 rows)

USE sakila;

SELECT c.name AS category_name
	, COUNT(fa.actor_id) AS actor_count

FROM film_actor AS fa

INNER JOIN film AS f
	ON fa.film_id = f.film_id

INNER JOIN film_category AS fc
	ON f.film_id = fc.film_id
    
INNER JOIN category AS c
	ON fc.category_id = c.category_id
    
GROUP BY c.name
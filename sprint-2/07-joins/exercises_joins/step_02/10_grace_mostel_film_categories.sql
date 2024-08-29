-- 10. Count of films in each category
-- that GRACE MOSTEL has appeared in as an actress

-- include first_name, last_name, category_name, film_count

-- (11 rows)

USE sakila;

SELECT a.first_name AS first_name
	, a.last_name AS last_name
    , c.name AS category_name
    , COUNT(f.film_id) AS film_count
FROM actor AS a

INNER JOIN film_actor AS fa
	ON a.actor_id = fa.actor_id
    
INNER JOIN film AS f
	ON fa.film_id = f.film_id
    
INNER JOIN film_category AS fc
	ON f.film_id = fc.film_id
    
INNER JOIN category AS c
	ON fc.category_id = c.category_id
    
WHERE a.first_name = "GRACE" AND a.last_name = "MOSTEL"

GROUP BY c.name
	, a.last_name
-- 7. List the names of all actors who acted in
-- the film "HUMAN GRAFFITI"

-- (4 rows)

USE sakila;

SELECT *

FROM film AS f

INNER JOIN film_actor AS fa
	ON f.film_id = fa.film_id

INNER JOIN actor AS a
	ON fa.actor_id = a.actor_id
    
WHERE title = "HUMAN GRAFFITI";
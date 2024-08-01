USE northwind;

-- Insert a new category into the Categories table
-- category name: Sporting Goods
-- description: All products that relate to recreational activities.
--              This includes equipment needed for team sports as well
--              as outdoor activities such as camping or river rafting.


INSERT INTO categories
(
	category_name
    , description
)
VALUES
(
    'Sporting Goods'
    , 'All products that relate to recreational activities. This includes equipment needed for team sports as well as outdoor activities such as camping or river rafting.'
)

-- I accidentally ran this twice and it added a duplicate row so I used 'DELETE FROM category_id = 10' to get rid of it
-- Ran it again so that the next exercise returns an id that is tied to a product
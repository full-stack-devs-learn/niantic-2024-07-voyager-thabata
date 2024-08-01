USE northwind;

-- Delete the Sporting Goods Category from the database.
DELETE FROM categories
WHERE category_id = 9;

-- Why does it fail to delete?
-- It fails to delete because we have products using this category in the database. Can't delete the parent: category_id is FK in products, PK in categories

-- What else needs to be done to fully delete the Category?
-- We need to remove the products inside the Sporting Goods category

-- Write a script that preforms all necessary steps to 
-- delete the category from the database.

-- The only user input should be a variable at the top of the 
-- script that holds the Category Name.
-- The sript should do the rest


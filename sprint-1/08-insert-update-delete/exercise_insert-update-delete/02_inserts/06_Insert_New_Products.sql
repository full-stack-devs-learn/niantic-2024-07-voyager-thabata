USE northwind;

-- Insert 10 new products into the new Sporting Goods Category
-- You can leave the Supplier Id empty for now, but you need to include
-- the product name, category, price, units in stock (20), units on order (0)
-- and re-order level (10) for each product.

INSERT INTO products (product_name, category_id, unit_price, units_in_stock, units_on_order, reorder_level)
VALUES ('Running Shoes', 9, 70, 20, 0, 10)
	, ('Dumbbells', 9, 15, 20, 0, 10)
    , ('Tennis Racket', 9, 250, 20, 0, 10)
    , ('Yoga Mat', 9, 20, 20, 0, 10)
    , ('Bicycle', 9, 300, 20, 0, 10)
    , ('Basketball', 9, 25, 20, 0, 10)
    , ('Soccer Ball', 9, 30, 20, 0, 10)
    , ('Baseball Glove', 9, 99, 20, 0, 10)
    , ('Golf Clubs', 9, 1500, 20, 0, 10)
    , ('Swimming Goggles', 9, 9.99, 20, 0, 10)
;
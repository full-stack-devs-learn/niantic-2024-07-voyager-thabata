USE northwind;

-- You were just hired by Northwind Traders, Inc and 
-- you need to add yourself as a Sales Associate to the Employees table.
-- Inlcude your:
    -- full name
    -- job title
    -- preferred title (Mr, Mrs, etc)
    -- Birthday
    -- hire date: (today)
    -- home address
-- leave all other fields null by default

-- ^ I had to enter '' for notes because it doesn't have a default value (should I have used 'NULL' or NULL instead?)

INSERT INTO employees (last_name, first_name, title, title_of_courtesy, birth_date, hire_date, address, city, region, postal_code, country, notes)
VALUES ('Betts', 'Tabatha', 'Sales Representative', 'Mrs.', '1988-06-03', '2024-07-31', '3619 Bill McDonald Pkwy', 'Bellingham', 'WA', '98225', 'USA', '');
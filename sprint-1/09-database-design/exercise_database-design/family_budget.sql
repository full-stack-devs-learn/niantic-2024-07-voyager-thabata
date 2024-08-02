DROP DATABASE IF EXISTS family_budget;

CREATE DATABASE family_budget;

USE family_budget;

CREATE TABLE person
(
	person_id INT NOT NULL AUTO_INCREMENT,
    person_name VARCHAR (20),
    PRIMARY KEY (person_id)
);


CREATE TABLE expenses
(
	expense_id INT NOT NULL AUTO_INCREMENT,
    person_id INT,
    expense_date DATE,
    expense_amount DECIMAL (10,2),
    sub_category_id INT,
    vendor_id INT,
    notes TEXT,
    PRIMARY KEY (expense_id)
);


CREATE TABLE vendors
(
	vendor_id INT NOT NULL AUTO_INCREMENT,
    vendor_name VARCHAR(30),
    PRIMARY KEY (vendor_id)
);


CREATE TABLE sub_categories
(
	sub_category_id INT NOT NULL AUTO_INCREMENT,
    category_id INT,
    sub_category_name VARCHAR(20),
    PRIMARY KEY (sub_category_id)
);    


CREATE TABLE categories
(
	category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR (20),
    PRIMARY KEY (category_id)
);


-- ADD FOREIGN CONSTRAINTS:
ALTER TABLE expenses
ADD CONSTRAINT fk_expenses_person
FOREIGN KEY (person_id) REFERENCES person (person_id);

ALTER TABLE expenses
ADD CONSTRAINT fk_expenses_sub_category_id
FOREIGN KEY (sub_category_id) REFERENCES sub_categories (sub_category_id);

ALTER TABLE expenses
ADD CONSTRAINT fk_expenses_vendors
FOREIGN KEY (vendor_id) REFERENCES vendors (vendor_id);

ALTER TABLE sub_categories
ADD CONSTRAINT fk_sub_categories_categories
FOREIGN KEY (category_id) REFERENCES categories (category_id);


-- ADD DATA TO THE TABLES:
INSERT INTO person (person_name) VALUES ('Tabatha'), ('Raymond');


INSERT INTO categories (category_name) VALUES ('Entertainment'), ('Food'), ('Healthcare'), ('Housing'), ('Transportation'), ('Vacation/Travel');


INSERT INTO sub_categories (sub_category_name, category_id) VALUES ('Internet', 4), ('Rent', 4), ('Utilities', 4), ('Gas', 5), ('Groceries', 2), ('Rx', 3), ('Games', 1), ('Flight', 6), ('Uber', 5), ('Restaurant', 2), ('Dr Visit', 3), ('Streaming Services', 1), ('Hotel', 6), ('Car maintenance', 5), ('Snacks', 2), ('OTC medicine', 3), ('TS Merch', 1), ('Misc', 1);


INSERT INTO vendors (vendor_name) VALUES ('Amazon'), ('Target'), ('Fred Meyer'), ('Walgreens'), ('Dollar Tree'), ('Landmark'), ('PSE'), ('Hulu'), ('Discovery+'), ('Steam'), ('Final Fantasy XIV'), ('Nintendo'), ('Peacock'), ('Bellingham Bay Dental'), ('Mount Baker Dental'), ('5 guys'), ('Taylor Swift Store'), ('Etsy'), ('Costco'), ('Insomnia Cookies'), ('Comcast'), ('Clarity Mental Health'), ('Visible'), ('Dairy Queen'), ('Spotify'), ('Taco Bell');



-- ADD RANDOM EXPENSES TO THE DATABASE:
INSERT INTO expenses(person_id, expense_date, expense_amount, sub_category_id, vendor_id, notes) 
VALUES
	(1, '2024-07-02', 150, 18, 1, 'misc')
    , (2, '2024-07-01', 17, 7, 11, 'FFXIV subscription')
    , (1, '2024-07-02', 150, 17, 17, 'folklore cardigan')
    , (1, '2024-07-01', 2087, 2, 6, 'rent')
    , (2, '2024-07-03', 7.99, 10, 24, 'lunch')
    , (1, '2024-07-05', 40, 4, 19, 'gas')
    , (1, '2024-07-08', 5.25, 15, 5, 'candy')
    , (1, '2024-07-11', 160, 11, 15, 'dentist')
    , (1, '2024-07-13', 95, 6, 4, 'refills')
    , (1, '2024-07-22', 30, 10, 16, 'dinner') 
    , (2, '2024-07-07', 9.99, 10, 26, 'lunch')
    , (2, '2024-07-12', 80, 1, 21, 'internet')
    , (2, '2024-07-14', 65, 7, 1, 'video game')
    , (2, '2024-07-25', 190, 5, 3, 'groceries')
    , (2, '2024-07-31', 20, 12, 8, 'Hulu subscription');


    
-- VARIABLE TO ADD NEW EXPENSES:
SET @person_name = 'Tabatha';
SET @expense_date = '2024-07-30';
SET @expense_amount = 17.89;
SET @vendor_name = 'Dairy Queen';
SET @notes = 'snack';
SET @sub_category_name = 'Restaurant';
SET @expense_id = LAST_INSERT_ID();

SELECT person_id INTO @person_id FROM person WHERE person_name = @person_name;
SELECT vendor_id INTO @vendor_id FROM vendors WHERE vendor_name = @vendor_name;
SELECT sub_category_id INTO @sub_category_id FROM sub_categories WHERE sub_category_name = @sub_category_name;

INSERT INTO expenses (person_id, expense_date, expense_amount, sub_category_id, vendor_id, notes)
VALUES (@person_id, @expense_date, @expense_amount, @sub_category_id, @vendor_id, @notes);



-- GENERATE REPORT:
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


INSERT INTO sub_categories (sub_category_name, category_id) VALUES ('Internet', 4), ('Rent', 4), ('Utilities', 4), ('Gas', 5), ('Groceries', 2), ('Rx', 3), ('Games', 1), ('Flight', 6), ('Uber', 5), ('Restaurant', 2), ('Dr Visit', 3), ('Streaming Services', 1), ('Hotel', 6), ('Car maintanence', 5), ('Snacks', 2), ('OTC medicine', 3);


INSERT INTO vendors (vendor_name) VALUES ('Amazon'), ('Target'), ('Fred Meyer'), ('Walgreens'), ('Dollar Tree'), ('Landmark'), ('PSE'), ('Hulu'), ('Discovery+'), ('Steam'), ('Final Fantasy XIV'), ('Nintendo'), ('Peacock'), ('Bellingahm Bay Dental'), ('Mount Baker Dental'), ('5 guys'), ('Taylor Swift Store'), ('Etsy'), ('Costco'), ('Insomnia Cookies'), ('Comcast'), ('Clarity Mental Health'), ('Visible'), ('Dairy Queen'), ('Spotify'), ('Taco Bell');

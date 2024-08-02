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
    person_id INT NULL,
    expense_date DATE,
    expense_amount DECIMAL (10,2),
    category_id INT NULL,
    vendor VARCHAR(30),
    notes TEXT,
    PRIMARY KEY (expense_id)
);


CREATE TABLE categories
(
	category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR (20),
    PRIMARY KEY (category_id)
);


CREATE TABLE sub_categories
(
	sub_category_id INT NOT NULL AUTO_INCREMENT,
    category_id INT NULL,
    sub_category_name VARCHAR(20),
    PRIMARY KEY (sub_category_id)
);


-- ADD FOREIGN CONSTRAINTS:
ALTER TABLE expenses
ADD CONSTRAINT fk_expenses_person
FOREIGN KEY (person_id) REFERENCES person (person_id);

ALTER TABLE expenses
ADD CONSTRAINT fk_expenses_categories
FOREIGN KEY (category_id) REFERENCES categories (category_id);

ALTER TABLE sub_categories
ADD CONSTRAINT fk_subcategories_categories
FOREIGN KEY (category_id) REFERENCES categories (category_id);


-- ADD DATA TO THE TABLES:
INSERT INTO person (person_name) VALUES ('Tabatha'), ('Raymond');


INSERT INTO categories (category_name) VALUES ('Entertainment'), ('Food'), ('Healthcare'), ('Housing'), ('Transportation'), ('Vacation/Travel');


INSERT INTO sub_categories (sub_category_name) VALUES ('Internet'), ('Rent'), ('Utilities'), ('Gas'), ('Groceries'), ('Rx'), ('Movies'), ('Flight'), ('Subway'), ('Restaurant'), ('Dr Visit'), ('Netflix'), ('Hotel'), ('Car maintanence'), ('Snacks'), ('OTC medicine'), ('Sports'), ('Car Rental');

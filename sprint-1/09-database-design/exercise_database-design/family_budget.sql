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


CREATE TABLE vendor
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
ADD CONSTRAINT fk_expenses_vendor
FOREIGN KEY (vendor_id) REFERENCES vendor (vendor_id);

ALTER TABLE sub_categories
ADD CONSTRAINT fk_sub_categories_categories
FOREIGN KEY (category_id) REFERENCES categories (category_id);


-- ADD DATA TO THE TABLES:
INSERT INTO person (person_name) VALUES ('Tabatha'), ('Raymond');


INSERT INTO categories (category_name) VALUES ('Entertainment'), ('Food'), ('Healthcare'), ('Housing'), ('Transportation'), ('Vacation/Travel');


INSERT INTO sub_categories (sub_category_name) VALUES ('Internet'), ('Rent'), ('Utilities'), ('Gas'), ('Groceries'), ('Rx'), ('Games'), ('Flight'), ('Uber'), ('Restaurant'), ('Dr Visit'), ('Streaming Services'), ('Hotel'), ('Car maintanence'), ('Snacks'), ('OTC medicine');
USE family_budget;

SET @person_name = 'Tabatha';
SET @expense_date = CURRENT_DATE;
SET @expense_amount = 50;
SET @vendor_name = 'Amazon';
SET @notes = 'test';
SET @sub_category_name = 'Food';
SET @expense_id = LAST_INSERT_ID();

SELECT person_id INTO @person_id FROM person WHERE person_name = @person_name;
SELECT vendor_id INTO @vendor_id FROM vendors WHERE vendor_name = @vendor_name;
SELECT sub_category_id INTO @sub_category_id FROM sub_categories WHERE sub_category_name = @sub_category_name;

INSERT INTO expenses (person_id, expense_date, expense_amount, sub_category_id, vendor_id, notes)
VALUES (@person_id, @expense_date, @expense_amount, @sub_category_id, @vendor_id, @notes);
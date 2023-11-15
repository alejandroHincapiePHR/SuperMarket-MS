-- Entrada 1
INSERT INTO customer (points, first_name, last_name, email, phone_number, status)
VALUES (100, 'John', 'Doe', 'johndoe@example.com', '123-456-7890', 'Active');

-- Entrada 2
INSERT INTO customer (points, first_name, last_name, email, phone_number, status)
VALUES (250, 'Alice', 'Smith', 'alice@example.com', '987-654-3210', 'Active');

-- Entrada 3
INSERT INTO customer (points, first_name, last_name, email, phone_number, status)
VALUES (50, 'Bob', 'Johnson', 'bob@example.com', '555-123-4567', 'Inactive');

-- Entrada 4
INSERT INTO customer (points, first_name, last_name, email, phone_number, status)
VALUES (300, 'Eva', 'Brown', 'eva@example.com', '777-888-9999', 'Active');

-- Entrada 5
INSERT INTO customer (points, first_name, last_name, email, phone_number, status)
VALUES (75, 'Michael', 'Wilson', 'michael@example.com', '333-444-5555', 'Active');

SELECT * FROM customer.customer;

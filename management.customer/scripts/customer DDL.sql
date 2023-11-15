USE customer;

CREATE TABLE IF NOT EXISTS customer (
    customer_id INT AUTO_INCREMENT,
    points INT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(20),
    status VARCHAR(255),
    PRIMARY KEY (customer_id)
);




USE product;

CREATE TABLE IF NOT EXISTS product (
    id BIGINT NOT NULL AUTO_INCREMENT,
    sku VARCHAR(255),
    product_name VARCHAR(255),
    available_units INT,
    customer_cost DOUBLE,
    company_cost DOUBLE,
    PRIMARY KEY (id)
);

INSERT INTO product (sku, product_name, available_units, customer_cost, company_cost)
VALUES
    ('SKU123', 'Producto 1', 100, 19.99, 15.00),
    ('SKU456', 'Producto 2', 75, 29.99, 22.50),
    ('SKU789', 'Producto 3', 50, 14.99, 11.00),
    ('SKU111', 'Producto 4', 120, 9.99, 7.50),
    ('SKU222', 'Producto 5', 90, 39.99, 30.00);

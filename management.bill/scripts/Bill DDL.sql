use bill;

CREATE TABLE IF NOT EXISTS invoice_line_item (
    invoice_line_item_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT,
    quantity INT,
    discount DOUBLE,
    taxes DOUBLE,
    subtotal DOUBLE,
    points DOUBLE
);

CREATE TABLE IF NOT EXISTS total_line_item (
    total_line_item_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    total_quantity_products INT,
    total_taxes DOUBLE,
    total_to_pay DOUBLE,
    total_accumulated_points DOUBLE
);

CREATE TABLE IF NOT EXISTS bill (
    bill_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    issue_date DATE,
    customer_id BIGINT,
    total_line_item_id BIGINT,
    FOREIGN KEY (total_line_item_id) REFERENCES total_line_item(total_line_item_id)
);

CREATE TABLE IF NOT EXISTS bill_invoice_line_item (
    bill_id BIGINT,
    invoice_line_item_id BIGINT,
    PRIMARY KEY (bill_id, invoice_line_item_id),
    FOREIGN KEY (bill_id) REFERENCES bill(bill_id),
    FOREIGN KEY (invoice_line_item_id) REFERENCES invoice_line_item(invoice_line_item_id)
);

CREATE TABLE orders (
    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    product_code        VARCHAR(255) NOT NULL,
    product_name        VARCHAR(255) NOT NULL,
    product_quantity    INT NOT NULL,
    product_price       DECIMAL(19,2) NOT NULL,
    order_status        VARCHAR(255) NOT NULL,  

    created_date        TIMESTAMP NOT NULL,  
    last_modified_date  TIMESTAMP NOT NULL, 
    version             INTEGER NOT NULL
);
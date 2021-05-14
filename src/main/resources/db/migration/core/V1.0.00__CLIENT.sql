CREATE TABLE client
(
    id           VARCHAR(50)  NOT NULL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    address_id   VARCHAR(50)  NOT NULL,
    created_date TIMESTAMP
);

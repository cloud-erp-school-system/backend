CREATE TABLE client_user
(
    id VARCHAR(50) NOT NULL PRIMARY KEY,
    client_id    VARCHAR(50) NOT NULL,
    address_id  VARCHAR(50) NOT NULL,
    created_date TIMESTAMP
);

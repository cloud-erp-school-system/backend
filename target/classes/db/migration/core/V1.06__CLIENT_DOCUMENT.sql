CREATE TABLE client_document
(
    id VARCHAR(50) NOT NULL PRIMARY KEY,
    client_id    VARCHAR(50) NOT NULL,
    username  VARCHAR(50) NOT NULL,
    created_date TIMESTAMP
);

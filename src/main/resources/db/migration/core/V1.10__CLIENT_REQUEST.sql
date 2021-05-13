CREATE TABLE client_client_request
(
    id VARCHAR(50) NOT NULL PRIMARY KEY,
    client_id    VARCHAR(50) NOT NULL,
    client_request_id  VARCHAR(50) NOT NULL,
    created_date TIMESTAMP
);

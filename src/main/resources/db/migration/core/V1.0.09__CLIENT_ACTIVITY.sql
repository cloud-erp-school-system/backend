CREATE TABLE client_activity
(
    id VARCHAR(50) NOT NULL PRIMARY KEY,
    client_id    VARCHAR(50) NOT NULL,
    activity_id  VARCHAR(50) NOT NULL,
    created_date TIMESTAMP
);

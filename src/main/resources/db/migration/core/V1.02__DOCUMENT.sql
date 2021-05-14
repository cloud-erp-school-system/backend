CREATE TABLE document
(
    id           VARCHAR(50)  NOT NULL PRIMARY KEY,
    uri          VARCHAR(250) NOT NULL,
    file_type    VARCHAR(20)  NOT NULL,
    file_size    BIGINT(12) NOT NULL,
    storage      VARCHAR(10)  NOT NUll,
    created_date TIMESTAMP
);

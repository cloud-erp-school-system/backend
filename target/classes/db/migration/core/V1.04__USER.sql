CREATE TABLE user
(
    `username`   VARCHAR(50) NOT NULL PRIMARY KEY,
    `first_name` VARCHAR(255),
    `last_name`  VARCHAR(255),
    `phone`      VARCHAR(255),
    `primary`    tinyint DEFAULT 0
);

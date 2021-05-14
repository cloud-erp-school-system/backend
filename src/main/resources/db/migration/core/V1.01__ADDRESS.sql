CREATE TABLE address
(
    `id`       VARCHAR(50) NOT NULL PRIMARY KEY,
    `primary`  TINYINT DEFAULT 0,
    `street`   VARCHAR(255),
    `postcode` VARCHAR(15),
    `city`     VARCHAR(255),
    `country`  VARCHAR(255)
);

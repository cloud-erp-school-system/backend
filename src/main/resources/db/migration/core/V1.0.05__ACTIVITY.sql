CREATE TABLE activity
(
    id                VARCHAR(50) NOT NULL PRIMARY KEY,
    category          VARCHAR(50) NOT NULL,
    referencing       VARCHAR(50) NOT NULL,
    short_description TINYTEXT,
    description       TEXT,
    created           TIMESTAMP,
    created_by_id     VARCHAR(50) NOT NULL,
    CONSTRAINT `fk_caller` FOREIGN KEY (created_by_id) REFERENCES user (username)
);


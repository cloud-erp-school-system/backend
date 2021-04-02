CREATE TABLE customer
(
    id         BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(90),
    last_name  VARCHAR(90)
);

CREATE TABLE organization
(
    uuid           VARCHAR(50) NOT NULL PRIMARY KEY,
    school_name    VARCHAR(100) NOT NULL,
    school_address VARCHAR(200) NOT NULL,
    verification_status VARCHAR(10) NOT NULL,
    created_by     VARCHAR(50) NOT NULL,
    created_date   TIMESTAMP,
    modified_by    VARCHAR(50) NOT NULL,
    modified_date  TIMESTAMP
);

CREATE TABLE files
(
    uuid          VARCHAR(50) NOT NULL PRIMARY KEY,
    org_id        VARCHAR(50) NOT NULL REFERENCES organization,
    relative_path VARCHAR(200) NOT NULL,
    file_name     VARCHAR(100) NOT NULL,
    file_type     VARCHAR(20)  NOT NULL,
    file_size     BIGINT(12)   NOT NULL,
    storage       VARCHAR(10)   NOT NUll,
    created_by    VARCHAR(50) NOT NULL,
    created_date  TIMESTAMP,
    modified_by   VARCHAR(50) NOT NULL,
    modified_date TIMESTAMP
);

CREATE TABLE client
  (
     id                  VARCHAR(50) NOT NULL PRIMARY KEY,
     name                VARCHAR(100) NOT NULL,
     website             VARCHAR(100) NOT NULL,
     staff_size          VARCHAR(10) NOT NULL,
     student_size        VARCHAR(10) NOT NULL,
     verification_status VARCHAR(64) NOT NULL,
     created_date        TIMESTAMP
  );

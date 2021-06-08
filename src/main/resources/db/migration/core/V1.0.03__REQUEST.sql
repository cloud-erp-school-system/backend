CREATE TABLE client_request
(
    id               VARCHAR(50) NOT NULL PRIMARY KEY,
    caller_id        VARCHAR(50) NOT NULL,
    client_id        VARCHAR(50) NOT NULL,
    status           VARCHAR(25) NOT NULL,
    student_license  VARCHAR(25) NOT NULL,
    parent_license   VARCHAR(25) NOT NULL,
    academic_license VARCHAR(25) NOT NULL
);

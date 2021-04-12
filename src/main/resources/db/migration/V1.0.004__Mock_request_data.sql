INSERT INTO address(id, street, postcode, city, country)
VALUES ('TEST_ADRESS2', '1 Apple Park Way', '95014-0642', 'Cupertino', 'United States');
INSERT INTO client(id, name, address_id, created_date)
VALUES ('TEST_CLIENT2', 'Apple Inc.', 'TEST_ADRESS2', CURRENT_TIMESTAMP());
INSERT INTO address(id, street, postcode, city, country)
VALUES ('TEST_ADRESS3', '1 Apple Park Way', '95014-0642', 'Cupertino', 'United States');
INSERT INTO client(id, name, address_id, created_date)
VALUES ('TEST_CLIENT3', 'Apple Inc.', 'TEST_ADRESS3', CURRENT_TIMESTAMP());
INSERT INTO address(id, street, postcode, city, country)
VALUES ('TEST_ADRESS4', '1 Apple Park Way', '95014-0642', 'Cupertino', 'United States');
INSERT INTO client(id, name, address_id, created_date)
VALUES ('TEST_CLIENT4', 'Apple Inc.', 'TEST_ADRESS4', CURRENT_TIMESTAMP());



INSERT INTO client_request(id, client_id, status, created_date)
VALUES ('request1', 'TEST_CLIENT1', 'UNDER_REVIEW', CURRENT_TIMESTAMP());

INSERT INTO client_request(id, client_id, status, created_date)
VALUES ('request2', 'TEST_CLIENT2', 'PENDING', CURRENT_TIMESTAMP());

INSERT INTO client_request(id, client_id, status, created_date)
VALUES ('request3', 'TEST_CLIENT3', 'VERIFIED', CURRENT_TIMESTAMP());

INSERT INTO client_request(id, client_id, status, created_date)
VALUES ('request4', 'TEST_CLIENT4', 'REVERT', CURRENT_TIMESTAMP())

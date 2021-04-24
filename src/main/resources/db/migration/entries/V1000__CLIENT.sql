INSERT INTO address(id, street, postcode, city, country)
VALUES ('TEST_ADRESS1', '1 Apple Park Way', '95014-0642', 'Cupertino', 'United States');

INSERT INTO client(id, name, address_id, created_date)
VALUES ('TEST_CLIENT1', 'Apple Inc.', 'TEST_ADRESS1', CURRENT_TIMESTAMP());

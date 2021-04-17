CREATE TABLE address
(
    id       VARCHAR(50) NOT NULL PRIMARY KEY,
    street   VARCHAR(255),
    postcode VARCHAR(15),
    city     VARCHAR(255),
    country  VARCHAR(255)
);

alter table client
    add constraint FK_client_address foreign key (address_id) references address (id);
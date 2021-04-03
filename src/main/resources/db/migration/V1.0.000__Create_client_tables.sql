CREATE TABLE client
(
    id                  VARCHAR(50)  NOT NULL PRIMARY KEY,
    name                VARCHAR(100) NOT NULL,
    address_id          VARCHAR(50) NOT NULL,
    verification_status VARCHAR(10)  NOT NULL,
    created_date        TIMESTAMP
);

CREATE TABLE address
(
    id         VARCHAR(50)  NOT NULL PRIMARY KEY,
    street       VARCHAR(255),
    postcode     VARCHAR(15),
    city         VARCHAR(255),
    country      VARCHAR(255)
);

alter table client add constraint FK_organization_address foreign key (address_id) references address (id);

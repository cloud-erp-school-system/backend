CREATE TABLE client_request
(
    id            VARCHAR(50) NOT NULL PRIMARY KEY,
    client_id     VARCHAR(50) NOT NULL,
    status        VARCHAR(25) NOT NULL,
    created_date  TIMESTAMP,
    modified_date TIMESTAMP
);

alter table client_request
    add constraint FK_client_request foreign key (client_id) references client (id);

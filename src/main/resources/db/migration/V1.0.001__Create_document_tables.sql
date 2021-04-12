CREATE TABLE document
(
    id           VARCHAR(50)  NOT NULL PRIMARY KEY,
    uri          VARCHAR(250) NOT NULL,
    file_type    VARCHAR(20)  NOT NULL,
    file_size    BIGINT(12) NOT NULL,
    storage      VARCHAR(10)  NOT NUll,
    created_date TIMESTAMP
);

CREATE TABLE client_document
(
    id IDENTITY NOT NULL PRIMARY KEY,
    client_id    VARCHAR(50) NOT NULL,
    document_id  VARCHAR(50) NOT NULL,
    created_date TIMESTAMP
);

alter table client_document
    add constraint FK_client_document_client foreign key (client_id) references client (id);
alter table client_document
    add constraint FK_client_document_document foreign key (document_id) references document (id);

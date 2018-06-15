CREATE TABLE userEntities
(
    id INTEGER UNIQUE NOT NULL,
    name VARCHAR(255),
    surname VARCHAR(255),
    CONSTRAINT users_pk PRIMARY KEY (id)
);

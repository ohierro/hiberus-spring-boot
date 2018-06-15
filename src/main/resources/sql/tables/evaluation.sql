-- Tabla de Evaluacion de los Users segun un Criteria

CREATE TABLE evaluations
(

    id INTEGER UNIQUE NOT NULL,
    fk_user INTEGER NOT null references users,
    fk_criteria INTEGER NOT null references criteria,

    CONSTRAINT evaluations_pk PRIMARY KEY (id)

);


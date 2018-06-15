CREATE TABLE criteria
(
	id INTEGER NOT NULL PRIMARY KEY,
	name varchar(255),
	value INTEGER NOT NULL,
	description varchar(500) NULL
	criteriaGroup INTEGER NULL,
	    CONSTRAINT criteria_fk FOREIGN KEY (criteriaGroup)
	    REFERENCES criteriaGroup(id)
);

